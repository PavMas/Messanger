package com.trifcdr.chats.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trifcdr.chats.databinding.FragmentDialogBinding
import com.trifcdr.chats.di.ChatsComponentHolder
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.chats.navigation.ChatsToDialogArgs
import com.trifcdr.chats.recycler.BaseRecyclerAdapter
import com.trifcdr.chats.recycler.itemModels.CompanionMessageItem
import com.trifcdr.chats.recycler.itemModels.MessageItem
import com.trifcdr.chats.recycler.itemModels.StringId
import com.trifcdr.chats.recycler.listener.CustomItemClickListener
import com.trifcdr.chats.recycler.managers.ViewHoldersManager
import com.trifcdr.chats.viewmodel.ChatsViewModel
import com.trifcdr.chats.viewmodel.ChatsViewModelFactory
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject

class DialogFragment: Fragment() {

    private lateinit var binding: FragmentDialogBinding

    @Inject
    lateinit var chatsViewModelFactory: ChatsViewModelFactory

    @Inject
    lateinit var navigationApi: NavigationApi<ChatsDirections>

    private lateinit var viewModel: ChatsViewModel

    private lateinit var recycler: RecyclerView

    @Inject lateinit var viewHoldersManager: ViewHoldersManager

    private lateinit var itemsAdapter: BaseRecyclerAdapter

    private lateinit var send: ImageView
    private lateinit var input: EditText



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentDialogBinding.inflate(inflater, container, false)
        init()
        setDialogObserver()
        return binding.root
    }

    private fun setDialogObserver() {
        //here will be dialog request observer
        //hardcode
        val items = mutableListOf<StringId>(
            CompanionMessageItem(messageId = 1, companionName = "Иван Куренков", message = "Как дела, брат?"),
            MessageItem(messageId = 2, message = "Все в порядке"),
            CompanionMessageItem(messageId = 3, companionName = "Иван Куренков", message = "Добро. Ты когда будешь? Мы тебя ждем")
        )
        itemsAdapter.submitList(items)
    }

    private fun init() {
        viewModel = ViewModelProvider(this, chatsViewModelFactory)[ChatsViewModel::class]
        recycler = binding.dialog
        itemsAdapter = BaseRecyclerAdapter(viewHoldersManager, CustomItemClickListener {id, chatsId, type ->
            //onClick on message
        })
        recycler.apply {
            val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            adapter = itemsAdapter
        }
        send = binding.send
        input = binding.input
    }

    override fun onAttach(context: Context) {
        ChatsComponentHolder.get()
            .inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        if (isRemoving) {
            ChatsComponentHolder.clear()
        }
        super.onDetach()
    }
}