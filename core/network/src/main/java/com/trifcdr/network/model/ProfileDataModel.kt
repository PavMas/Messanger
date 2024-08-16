package com.trifcdr.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by trifcdr.
 */

@Serializable
data class ProfileDataModel(
    @SerialName("profile_data")
    val profileData: ProfileData
)