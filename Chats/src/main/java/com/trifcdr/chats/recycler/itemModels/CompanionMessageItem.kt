package com.trifcdr.chats.recycler.itemModels

import android.graphics.Bitmap

data class CompanionMessageItem(
    override val id: String = "companion_message",
    val messageId: Long,
    val companionName: String,
    val message: String
): StringId