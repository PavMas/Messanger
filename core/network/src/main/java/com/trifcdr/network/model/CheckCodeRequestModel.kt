package com.trifcdr.network.model

import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
class CheckCodeRequestModel(
    val phone: String,
    val code: String
)