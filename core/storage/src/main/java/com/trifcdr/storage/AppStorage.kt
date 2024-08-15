package com.trifcdr.storage

/**
 * Created by trifcdr.
 */
interface AppStorage {

    suspend fun saveTokens(accessToken: String, refreshToken: String): Boolean

    suspend fun getAccessToken(): String

    suspend fun getRefreshToken(): String
}