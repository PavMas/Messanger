package com.trifcdr.chats.recycler.itemModels

import android.graphics.Bitmap

data class  ChatsItem(
    override val id: String = "chats",
    val chatsId: Long,
    val avatar: Bitmap,
    val companionName: String,
    val lastMessage: String
): StringId