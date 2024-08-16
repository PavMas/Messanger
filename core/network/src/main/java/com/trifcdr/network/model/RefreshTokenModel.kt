package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
data class RefreshTokenModel(
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("user_id")
    val userId: String

)