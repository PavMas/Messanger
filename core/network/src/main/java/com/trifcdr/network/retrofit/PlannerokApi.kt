package com.trifcdr.network.retrofit

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthDataModel
import com.trifcdr.network.model.CheckCodeRequestModel
import com.trifcdr.network.model.ProfileDataModel
import com.trifcdr.network.model.RefreshTokenModel
import com.trifcdr.network.model.RefreshTokenRequestModel
import com.trifcdr.network.model.RegisterUserDataModel
import com.trifcdr.network.model.RegisterUserRequestModule
import com.trifcdr.network.model.SaveUserDataRequestModel
import com.trifcdr.network.model.SendCodeRequestModel
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT

interface PlannerokApi {

    @POST("api/v1/users/send-auth-code/")
    suspend fun sendAuthCode(@Body body: SendCodeRequestModel): AuthCodeModel

    @POST("/api/v1/users/check-auth-code/")
    suspend fun checkAuthCode(@Body body: CheckCodeRequestModel): AuthDataModel

    @POST("/api/v1/users/register/")
    suspend fun registerUser(@Body body: RegisterUserRequestModule): RegisterUserDataModel

    @GET("/api/v1/users/me/")
    suspend fun getUserData(@Header("Authorization") token: String): ProfileDataModel

    @POST("/api/v1/users/refresh-token/")
    suspend fun refreshAccessToken(@Body body: RefreshTokenRequestModel): RefreshTokenModel

    @PUT("/api/v1/users/me/")
    suspend fun updateUserData(
        @Header("Authorization") token: String,
        @Body userData: SaveUserDataRequestModel,
    )


    companion object {
        private var plannerokApiService: PlannerokApi? = null

        @OptIn(ExperimentalSerializationApi::class)
        fun getInstance(): PlannerokApi {
            if (plannerokApiService == null) {
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()

                val contentType = "application/json".toMediaType()
                val json = Json { ignoreUnknownKeys = true }
                val kotlinxConverterFactory = json.asConverterFactory(contentType)
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://plannerok.ru/")
                    .client(client)
                    .addConverterFactory(kotlinxConverterFactory)
                    .build()
                plannerokApiService = retrofit.create(PlannerokApi::class.java)
            }
            return plannerokApiService!!
        }
    }
}