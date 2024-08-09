package com.trifcdr.network.retrofit

import com.trifcdr.network.model.AuthCode
import com.trifcdr.network.model.AuthData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthorizationApi {

    @POST("api/v1/users/send-auth-code/")
    suspend fun sendAuthCode(@Body body: String): Call<AuthCode>

    @POST("/api/v1/users/check-auth-code")
    suspend fun checkAuthCode(@Body body: String): Call<AuthData>
}