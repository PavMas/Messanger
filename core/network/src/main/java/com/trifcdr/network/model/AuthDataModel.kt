package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import javax.inject.Named


@Serializable
data class AuthDataModel(
    @SerialName("refresh_token")
    val refreshToken: String,
    @SerialName("access_token")
    val accessToken: String,
    @SerialName("user_id")
    val userId: Long,
    @SerialName("is_user_exists")
    val isUserExist: Boolean
)