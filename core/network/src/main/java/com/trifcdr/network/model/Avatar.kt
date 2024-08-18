package com.trifcdr.network.model

import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
data class Avatar(
    val filename: String? = null,
    val base64: String? = null
)