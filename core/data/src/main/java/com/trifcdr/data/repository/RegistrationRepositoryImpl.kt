package com.trifcdr.data.repository

import com.trifcdr.data.mapper.mapAuthDataToDomain
import com.trifcdr.data.mapper.mapRegisterDataToDomain
import com.trifcdr.data.mapper.mapRegisterUserToData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.domain.repository.RegistrationRepository
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import retrofit2.HttpException

/**
 * Created by trifcdr.
 */
class RegistrationRepositoryImpl(
    private val api: PlannerokApi,
    private val storage: AppStorage
): RegistrationRepository {

    override suspend fun registerUser(user: RegisterUser): DomainResource<RegisterData> {
        val registerRequestModel = mapRegisterUserToData(user)
        return try {
            val res = api.registerUser(registerRequestModel)
            storage.saveTokens(
                accessToken = res.accessToken,
                refreshToken = res.refreshToken
            )
            DomainResource.Success(mapRegisterDataToDomain(res))
        } catch (error: Exception) {
                DomainResource.Failure(Exception())
            }
        }

}