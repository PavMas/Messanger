package com.trifcdr.network.model

import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */
@Serializable
data class SaveUserDataRequestModel(
    val name: String,
    val username: String,
    val birthday: String,
    val city: String,
    val vk: String,
    val instagram: String,
    val status: String,
    val avatar: Avatar? = null,
)