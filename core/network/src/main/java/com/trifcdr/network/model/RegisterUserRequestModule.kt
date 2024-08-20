package com.trifcdr.network.model

import kotlinx.serialization.Serializable
import javax.inject.Named

/**
 * Created by trifcdr.
 */

@Serializable
data class RegisterUserRequestModule(
    val phone: String,
    val name: String,
    val username: String
)