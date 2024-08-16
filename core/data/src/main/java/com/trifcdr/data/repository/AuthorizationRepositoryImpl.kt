package com.trifcdr.data.repository

import com.trifcdr.data.mapper.mapAuthCodeToDomain
import com.trifcdr.data.mapper.mapAuthDataToDomain
import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.network.model.CheckCodeRequestModel
import com.trifcdr.network.model.SendCodeRequestModel
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import retrofit2.HttpException
import javax.inject.Inject

class AuthorizationRepositoryImpl @Inject constructor(
    private val api: PlannerokApi,
    private val storage: AppStorage,
) : AuthorizationRepository {

    override suspend fun sendAuthCode(phone: String): DomainResource<AuthCode> {
        val sendCodeModel = SendCodeRequestModel(phone)
        return DomainResource.Success(mapAuthCodeToDomain(api.sendAuthCode(sendCodeModel)))
    }


    override suspend fun checkAuthCode(phone: String, code: String): DomainResource<AuthData> {
        val checkCodeModel = CheckCodeRequestModel(phone, code)
        return try {
            val res = api.checkAuthCode(checkCodeModel)
            storage.saveTokens(
                accessToken = res.accessToken,
                refreshToken = res.refreshToken
            )
            DomainResource.Success(mapAuthDataToDomain(res))
        } catch (error: HttpException) {
            if (error.code() == 404) {
                DomainResource.Failure(Exception("Not Found"))
            } else {
                DomainResource.Failure(Exception("Unknown Exception"))
            }
        }
    }
}