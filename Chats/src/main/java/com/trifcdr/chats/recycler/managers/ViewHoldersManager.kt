package com.trifcdr.chats.recycler.managers

import com.trifcdr.chats.recycler.visitor.ViewHolderVisitor


/**
 * Created by trifcdr.
 */
interface ViewHoldersManager {

    fun registerViewHolder(type: Int, viewHolder: ViewHolderVisitor)

    fun getViewHolder(itemType: Int): ViewHolderVisitor

    fun getItemType(item: Any): Int
}