package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AuthCodeModel(
    @SerialName("is_success")
    val isSuccess: Boolean
)