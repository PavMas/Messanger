package com.trifcdr.profile.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by trifcdr.
 */

@Parcelize
data class ProfileEditArgs(
    val name: String,
    val username: String,
    val birthday: String?,
    val city: String?,
    val vk: String?,
    val instagram: String?,
    val status: String?,
    val avatar: String?,
    val id: Long,
    val phone: String,
) : Parcelable