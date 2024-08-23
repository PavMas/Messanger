package com.trifcdr.chats.recycler.holders

import androidx.databinding.ViewDataBinding
import com.trifcdr.chats.R
import com.trifcdr.chats.databinding.ItemChatBinding
import com.trifcdr.chats.databinding.ItemCompanionMessageBinding
import com.trifcdr.chats.recycler.itemModels.ChatsItem
import com.trifcdr.chats.recycler.itemModels.CompanionMessageItem
import com.trifcdr.chats.recycler.listener.CustomItemClickListener
import com.trifcdr.chats.recycler.visitor.ViewHolderVisitor

class CompanionMessageHolder: ViewHolderVisitor {

    override val layout = R.layout.item_companion_message
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?
    ) {
        with(binding as ItemCompanionMessageBinding){
            companionMessage = item as CompanionMessageItem
            sender.text = item.companionName
            message.text = item.message
        }
    }

    override fun acceptBinding(item: Any): Boolean = item is CompanionMessageItem

}