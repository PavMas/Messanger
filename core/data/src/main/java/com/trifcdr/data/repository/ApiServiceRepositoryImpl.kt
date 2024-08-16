package com.trifcdr.data.repository

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.network.model.RefreshTokenModel
import com.trifcdr.network.model.RefreshTokenRequestModel
import com.trifcdr.network.model.Resource
import com.trifcdr.network.repository.ApiServiceRepository
import com.trifcdr.network.retrofit.PlannerokApi
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ApiServiceRepositoryImpl @Inject constructor(
    private val api: PlannerokApi
): ApiServiceRepository {
    override suspend fun refreshToken(refreshToken: String): Resource<RefreshTokenModel> {
        return try{
            Resource.Success(api.refreshAccessToken(RefreshTokenRequestModel(refreshToken)))
        } catch (e: Exception){
            return Resource.Failure(e)
        }
    }
}