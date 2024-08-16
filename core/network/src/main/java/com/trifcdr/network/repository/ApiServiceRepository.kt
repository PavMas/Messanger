package com.trifcdr.network.repository

/**
 * Created by trifcdr.
 */
interface ApiServiceRepository {

    suspend fun refreshToken(refreshToken: String): String
}