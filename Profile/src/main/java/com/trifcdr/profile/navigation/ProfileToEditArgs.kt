package com.trifcdr.profile.navigation

/**
 * Created by trifcdr.
 */
data class ProfileToEditArgs(
    val name: String,
    val username: String,
    val birthday: String,
    val city: String,
    val vk: String,
    val instagram: String,
    val status: String,
    val avatar: String,
    val id: Long,
    val phone: String,
)