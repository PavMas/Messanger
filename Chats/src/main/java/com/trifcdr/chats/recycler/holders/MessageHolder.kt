package com.trifcdr.chats.recycler.holders

import androidx.databinding.ViewDataBinding
import com.trifcdr.chats.R
import com.trifcdr.chats.databinding.ItemCompanionMessageBinding
import com.trifcdr.chats.databinding.ItemMessageBinding
import com.trifcdr.chats.recycler.itemModels.ChatsItem
import com.trifcdr.chats.recycler.itemModels.CompanionMessageItem
import com.trifcdr.chats.recycler.itemModels.MessageItem
import com.trifcdr.chats.recycler.listener.CustomItemClickListener
import com.trifcdr.chats.recycler.visitor.ViewHolderVisitor

class MessageHolder: ViewHolderVisitor {

    override val layout = R.layout.item_message
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?
    ) {
        with(binding as ItemMessageBinding){
            messageItem = item as MessageItem
            sender.text = item.name
            message.text = item.message
        }
    }

    override fun acceptBinding(item: Any): Boolean = item is CompanionMessageItem

}