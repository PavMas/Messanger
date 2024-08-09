package com.trifcdr.network.model

data class AuthData(
    val access_token: String,
    val refresh_token: String,
    val user_id: Long,
    val is_user_exist: Boolean
)