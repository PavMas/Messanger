package com.trifcdr.network.repository

import com.trifcdr.network.model.RefreshTokenModel
import com.trifcdr.network.model.Resource

/**
 * Created by trifcdr.
 */
interface ApiServiceRepository {

    suspend fun refreshToken(refreshToken: String): Resource<RefreshTokenModel>
}