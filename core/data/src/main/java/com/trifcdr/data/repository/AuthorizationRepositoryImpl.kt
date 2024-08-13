package com.trifcdr.data.repository

import com.trifcdr.data.mapper.mapAuthCodeToDomain
import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.network.model.SendCodeRequestModel
import com.trifcdr.network.retrofit.AuthorizationApi
import retrofit2.Retrofit
import javax.inject.Inject

//
//interface AuthorizationRepository {
//    suspend fun sendAuthCode(phone: String): Resource<AuthCode>
//    suspend fun checkAuthCode(phone: String, code: String): Resource<AuthData>
//}

class AuthorizationRepositoryImpl (private val retrofit: Retrofit) : AuthorizationRepository {
    override suspend fun sendAuthCode(phone: String): DomainResource<AuthCode> {
        val authApi = retrofit.create(AuthorizationApi::class.java)
        val sendCodeModel = SendCodeRequestModel(phone)
        return DomainResource.Success(mapAuthCodeToDomain(authApi.sendAuthCode(sendCodeModel)))
    }

//    override suspend fun checkAuthCode(phone: String, code: String): Resource<AuthData> {
//        val authApi = network.getRetrofit().create(AuthorizationApi::class.java)
//        val body = CheckCodeRequestModel(phone, code)
//        val response = authApi.checkAuthCode(body)
//        var responseFromServer: Resource<AuthData> = Resource.Empty
//        CoroutineScope(Dispatchers.IO).launch {
//            //val checkCodeResponse = response.execute()
//            //responseFromServer = Resource.Success(checkCodeResponse.body()!!)
//        }.join()
//        return responseFromServer
//    }
}