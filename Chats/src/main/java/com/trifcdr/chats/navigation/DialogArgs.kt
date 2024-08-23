package com.trifcdr.chats.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DialogArgs(
    val dialogId: Long
): Parcelable