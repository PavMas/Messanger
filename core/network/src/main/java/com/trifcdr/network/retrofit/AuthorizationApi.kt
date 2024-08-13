package com.trifcdr.network.retrofit

import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthData
import com.trifcdr.network.model.CheckCodeRequestModel
import com.trifcdr.network.model.SendCodeRequestModel
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthorizationApi {

    @POST("api/v1/users/send-auth-code/")
    suspend fun sendAuthCode(@Body body: SendCodeRequestModel): AuthCodeModel

    @POST("/api/v1/users/check-auth-code/")
    suspend fun checkAuthCode(@Body body: CheckCodeRequestModel): AuthData
}