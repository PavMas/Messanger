package com.trifcdr.data.repository

import com.trifcdr.data.mapper.mapProfileDataToDomain
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.repository.ProfileRepository
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
            val token = storage.getAccessToken()
            val res = api.getUserData(token)
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
}
