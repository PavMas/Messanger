package com.trifcdr.network.model

import kotlinx.serialization.Serializable


@Serializable
data class AuthData(
    val access_token: String,
    val refresh_token: String,
    val user_id: Long,
    val is_user_exist: Boolean
)