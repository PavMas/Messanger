package com.trifcdr.data.repository

import com.trifcdr.data.mapper.mapProfileDataToDomain
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.repository.ProfileRepository
import com.trifcdr.network.repository.ApiServiceRepository
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import retrofit2.HttpException
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ProfileRepositoryImpl(
    private val api: PlannerokApi,
    private val storage: AppStorage,
) : ProfileRepository {

    @Inject
    lateinit var apiServiceRepository: ApiServiceRepository

    override suspend fun getProfileData(): DomainResource<ProfileData> {
        return try {
            val res = api.getUserData(storage.getAccessToken())
            DomainResource.Success(mapProfileDataToDomain(res))

        } catch (error: HttpException) {
            if (error.code() == 401) {

            }
            DomainResource.Failure(Exception())
        }
    }
}
