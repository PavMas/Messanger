package com.trifcdr.data.repository

import com.trifcdr.data.mapper.mapProfileDataToDomain
import com.trifcdr.data.mapper.mapUpdateDataToData
import com.trifcdr.data.mapper.mapUserDataToStorage
import com.trifcdr.data.mapper.mapUserStorageDataToDomain
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.models.ProfileDataRequest
import com.trifcdr.domain.repository.ProfileRepository
import com.trifcdr.network.model.ProfileDataModel
import com.trifcdr.network.model.Resource
import com.trifcdr.network.repository.ApiServiceRepository
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ProfileRepositoryImpl @Inject constructor(
    private val api: PlannerokApi,
    private val storage: AppStorage,
    private val serviceRepository: ApiServiceRepository
) : ProfileRepository {

    @Inject
    lateinit var apiServiceRepository: ApiServiceRepository

    override suspend fun getProfileData(): DomainResource<ProfileData> {
        return try {
            val res: ProfileDataModel
            if (!storage.isAuthorized()){
                val token = storage.getAccessToken()
                res = api.getUserData(token)
                storage.saveUserData(mapUserDataToStorage(res))
            } else{
                res = mapUserStorageDataToDomain(storage.getUserData())
            }
            DomainResource.Success(mapProfileDataToDomain(res))

        } catch (error: HttpException) {
            if (error.code() == 401) {
                try{
                    val res = serviceRepository.refreshToken(storage.getRefreshToken())
                    if (res is Resource.Success){
                        storage.saveTokens(res.result.accessToken, res.result.refreshToken)
                        getProfileData()
                    }
                }
                catch (e: Exception){
                    DomainResource.Unauthorized
                }
            }
            DomainResource.Unauthorized
        }
    }

    override suspend fun updateProfileData(data: ProfileDataRequest): DomainResource<Boolean> {
        return try{
            api.updateUserData(storage.getAccessToken(), mapUpdateDataToData(data))
            storage.saveUserData(mapUserDataToStorage(data))
            DomainResource.Success(true)
        }catch (e: Exception){
            DomainResource.Failure(e)
        }
    }
}
