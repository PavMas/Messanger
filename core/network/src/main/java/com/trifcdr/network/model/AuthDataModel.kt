package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import javax.inject.Named


@Serializable
data class AuthDataModel(
    @SerialName("refresh_token")
    val refreshToken: String? = null,
    @SerialName("access_token")
    val accessToken: String? = null,
    @SerialName("user_id")
    val userId: Long? = null,
    @SerialName("is_user_exists")
    val isUserExist: Boolean
)