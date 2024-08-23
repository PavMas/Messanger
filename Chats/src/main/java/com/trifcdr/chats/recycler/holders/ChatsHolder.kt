package com.trifcdr.chats.recycler.holders

import androidx.databinding.ViewDataBinding
import com.trifcdr.chats.R
import com.trifcdr.chats.databinding.ItemChatBinding
import com.trifcdr.chats.recycler.itemModels.ChatsItem
import com.trifcdr.chats.recycler.listener.CustomItemClickListener
import com.trifcdr.chats.recycler.visitor.ViewHolderVisitor

class ChatsHolder: ViewHolderVisitor {

    override val layout = R.layout.item_chat
    override fun bind(
        binding: ViewDataBinding,
        item: Any,
        clickListener: CustomItemClickListener?
    ) {
        with(binding as ItemChatBinding){
            chats = item as ChatsItem
            name.text = item.companionName
            lastMessage.text = item.lastMessage
            avatar.setImageBitmap(item.avatar)
            layout.setOnClickListener{
                clickListener?.onClick(itemId = item.id, id = item.chatsId)
            }
        }
    }

    override fun acceptBinding(item: Any): Boolean = item is ChatsItem

}