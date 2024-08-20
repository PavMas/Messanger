package com.trifcdr.chats.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.trifcdr.chats.recycler.itemModels.StringId
import com.trifcdr.chats.recycler.listener.CustomItemClickListener
import com.trifcdr.chats.recycler.managers.ViewHoldersManager
import com.trifcdr.chats.recycler.visitor.ViewHolderVisitor

class BaseRecyclerAdapter(
    private val vHoldersManager: ViewHoldersManager,
    private val clickListener: CustomItemClickListener? = null,
) : ListAdapter<StringId, BaseRecyclerAdapter.DataViewHolder>(BaseDiffCallback()) {


    inner class DataViewHolder(
        private val binding: ViewDataBinding,
        private val holder: ViewHolderVisitor
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: StringId, clickListener: CustomItemClickListener? = null) =
            holder.bind(binding, item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        LayoutInflater.from(parent.context).run {
            val holder = vHoldersManager.getViewHolder(viewType)
            DataViewHolder(DataBindingUtil.inflate(this, holder.layout, parent, false), holder)
        }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(getItem(position), clickListener)


    override fun getItemViewType(position: Int): Int =
        vHoldersManager.getItemType(getItem(position))

    @SuppressLint("NotifyDataSetChanged")
    override fun submitList(list: MutableList<StringId>?) {
        super.submitList(list)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun submitList(list: MutableList<StringId>?, commitCallback: Runnable?) {
        super.submitList(list, commitCallback)
        notifyDataSetChanged()

    }
}

class BaseDiffCallback : DiffUtil.ItemCallback<StringId>() {
    override fun areItemsTheSame(oldItem: StringId, newItem: StringId): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: StringId, newItem: StringId): Boolean =
        oldItem == newItem
}