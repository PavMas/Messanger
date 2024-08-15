package com.trifcdr.network.model

import kotlinx.serialization.Serializable
import javax.inject.Named

/**
 * Created by trifcdr.
 */

@Serializable
data class RegisterUserDataModel(
    @Named("access_token")
    val accessToken: String,
    @Named("refresh_token")
    val refreshToken: String,
    @Named("user_id")
    val userId: Long
)
