package com.trifcdr.chats.recycler.visitor

import androidx.databinding.ViewDataBinding
import com.trifcdr.chats.recycler.listener.CustomItemClickListener

/**
 * Created by trifcdr.
 */
interface ViewHolderVisitor {
    val layout: Int

    fun bind(binding: ViewDataBinding, item: Any, clickListener: CustomItemClickListener?)
    fun acceptBinding(item: Any): Boolean

}