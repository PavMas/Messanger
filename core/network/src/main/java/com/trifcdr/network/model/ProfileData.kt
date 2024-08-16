package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
data class ProfileData(
    val name: String,
    val username: String,
    val birthday: String?,
    val city: String?,
    val vk: String?,
    val instagram: String?,
    val status: String?,
    val avatar: String?,
    val id: Long,
    val last: String?,
    val online: Boolean?,
    val created: String?,
    val phone: String,
    @SerialName("completed_task")
    val completedTask: Int?
)