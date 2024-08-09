package com.trifcdr.network.retrofit

import com.trifcdr.network.model.RegisterData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RegistrationApi {

    @POST("/api/v1/users/register")
    suspend fun registerUser(@Body body: String): Call<RegisterData>
}