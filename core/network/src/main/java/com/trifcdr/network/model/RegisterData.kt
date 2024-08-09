package com.trifcdr.network.model

data class RegisterData(
    val access_token: String,
    val refresh_token: String,
    val user_id: Long
)