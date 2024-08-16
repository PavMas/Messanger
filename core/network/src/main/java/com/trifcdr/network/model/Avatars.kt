package com.trifcdr.network.model

import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
data class Avatars(
    val avatar: String,
    val bigAvatar: String,
    val miniAvatar: String
)