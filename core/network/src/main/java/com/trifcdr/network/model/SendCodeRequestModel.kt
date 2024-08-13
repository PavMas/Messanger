package com.trifcdr.network.model

import kotlinx.serialization.Serializable


@Serializable
data class SendCodeRequestModel(
    val phone: String
)