package com.trifcdr.data.repository

import com.trifcdr.network.model.RefreshTokenRequestModel
import com.trifcdr.network.repository.ApiServiceRepository
import com.trifcdr.network.retrofit.PlannerokApi
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ApiServiceRepositoryImpl @Inject constructor(
    private val api: PlannerokApi
): ApiServiceRepository {

    override suspend fun refreshToken(refreshToken: String): String {
        return ""
    }
}