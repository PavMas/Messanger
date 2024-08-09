package com.trifcdr.data.repository

import com.trifcdr.network.model.AuthCode
import com.trifcdr.network.model.AuthData
import com.trifcdr.network.model.Network
import com.trifcdr.network.model.Resource
import com.trifcdr.network.model.SendCodeRequestModel
import com.trifcdr.network.retrofit.AuthorizationApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject

interface AuthorizationRepository {
    suspend fun sendAuthCode(phone: String): Resource<AuthCode>
    suspend fun checkAuthCode(phone: String, code: String): Resource<AuthData>
}

class AuthorizationRepositoryImpl(private val network: Network): AuthorizationRepository{
    override suspend fun sendAuthCode(phone: String): Resource<AuthCode> {
        val authApi = network.getRetrofit().create(AuthorizationApi::class.java)
        val sendCodeModel = SendCodeRequestModel(phone)
        val response = authApi.sendAuthCode(sendCodeModel)
        var responseFromServer: Resource<AuthCode> = Resource.Empty
        CoroutineScope(Dispatchers.IO).launch {
            val sendCodeResponse = response.execute()
            responseFromServer = Resource.Success(sendCodeResponse.body()!!)
        }.join()
        return responseFromServer
    }

    override suspend fun checkAuthCode(phone: String, code: String): Resource<AuthData> {
        val authApi = network.getRetrofit().create(AuthorizationApi::class.java)
        val body = JSONObject()
        body.put("phone", phone)
        body.put("code", code)
        val response = authApi.checkAuthCode(body.toString())
        var responseFromServer: Resource<AuthData> = Resource.Empty
        CoroutineScope(Dispatchers.IO).launch {
            val checkCodeResponse = response.execute()
            responseFromServer = Resource.Success(checkCodeResponse.body()!!)
        }.join()
        return responseFromServer
    }
}