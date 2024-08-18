package com.trifcdr.storage

import com.trifcdr.storage.model.UserData

/**
 * Created by trifcdr.
 */
interface AppStorage {

    suspend fun saveTokens(accessToken: String, refreshToken: String): Boolean

    suspend fun getAccessToken(): String

    suspend fun getRefreshToken(): String

    suspend fun saveUserData(data: UserData): Boolean

    suspend fun getUserData(): UserData

    suspend fun isAuthorized(): Boolean
}