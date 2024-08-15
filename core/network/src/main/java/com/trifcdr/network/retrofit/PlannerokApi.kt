package com.trifcdr.network.retrofit

import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthDataModel
import com.trifcdr.network.model.CheckCodeRequestModel
import com.trifcdr.network.model.RegisterData
import com.trifcdr.network.model.SendCodeRequestModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface PlannerokApi {

    @POST("api/v1/users/send-auth-code/")
    suspend fun sendAuthCode(@Body body: SendCodeRequestModel): AuthCodeModel

    @POST("/api/v1/users/check-auth-code/")
    suspend fun checkAuthCode(@Body body: CheckCodeRequestModel): AuthDataModel

    @POST("/api/v1/users/register")
    suspend fun registerUser(@Body body: String): RegisterData

    companion object {
        private var plannerokApiService: PlannerokApi? = null

        fun getInstance() : PlannerokApi {
            if(plannerokApiService == null){
                val logging = HttpLoggingInterceptor()
                logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                val client = OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .build()
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://plannerok.ru/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                plannerokApiService = retrofit.create(PlannerokApi::class.java)
            }
            return plannerokApiService!!
        }
    }
}