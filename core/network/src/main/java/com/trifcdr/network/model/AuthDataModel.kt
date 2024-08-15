package com.trifcdr.network.model

import kotlinx.serialization.Serializable
import javax.inject.Named


@Serializable
data class AuthDataModel(
    @Named("access_token")
    val accessToken: String,
    @Named("refresh_token")
    val refreshToken: String,
    @Named("user_id")
    val userId: Long,
    @Named("is_user_exist")
    val isUserExist: Boolean
)