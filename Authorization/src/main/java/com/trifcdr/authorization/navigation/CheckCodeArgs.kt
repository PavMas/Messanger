package com.trifcdr.authorization.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by trifcdr.
 */

@Parcelize
data class CheckCodeArgs(
    val phone: String
): Parcelable