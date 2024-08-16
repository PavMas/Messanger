package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
data class RefreshTokenRequestModel(
    @SerialName("refresh_token")
    val refreshToken: String
)