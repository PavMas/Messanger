package com.trifcdr.domain.models

/**
 * Created by trifcdr.
 */
data class ProfileDataRequest(
    val name: String,
    val username: String,
    val birthday: String,
    val city: String,
    val vk: String,
    val instagram: String,
    val status: String,
    val avatar: Avatar?,
)