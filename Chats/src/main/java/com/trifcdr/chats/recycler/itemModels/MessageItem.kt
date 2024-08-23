package com.trifcdr.chats.recycler.itemModels

data class MessageItem (
    override val id: String = "message",
    val messageId: Long,
    val name: String = "Вы",
    val message: String
): StringId