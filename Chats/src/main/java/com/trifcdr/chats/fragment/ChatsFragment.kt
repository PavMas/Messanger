package com.trifcdr.chats.fragment

import android.content.Context
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.trifcdr.chats.R
import com.trifcdr.chats.databinding.FragmentChatsBinding
import com.trifcdr.chats.di.ChatsComponentHolder
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.chats.navigation.ChatsToDialogArgs
import com.trifcdr.chats.recycler.BaseRecyclerAdapter
import com.trifcdr.chats.recycler.itemModels.ChatsItem
import com.trifcdr.chats.recycler.itemModels.StringId
import com.trifcdr.chats.recycler.listener.CustomItemClickListener
import com.trifcdr.chats.recycler.managers.ViewHoldersManager
import com.trifcdr.chats.viewmodel.ChatsViewModel
import com.trifcdr.chats.viewmodel.ChatsViewModelFactory
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject


/**
 * Created by trifcdr.
 */
class ChatsFragment : Fragment() {

    private lateinit var binding: FragmentChatsBinding

    @Inject
    lateinit var chatsViewModelFactory: ChatsViewModelFactory

    @Inject
    lateinit var navigationApi: NavigationApi<ChatsDirections>

    private lateinit var viewModel: ChatsViewModel

    private lateinit var recycler: RecyclerView

    @Inject lateinit var viewHoldersManager: ViewHoldersManager

    private lateinit var itemsAdapter: BaseRecyclerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        init()
        setClickListeners()
        setAuthObserver()
        return binding.root
    }

    private fun setAuthObserver() {
        viewModel.resultAuth.observe(viewLifecycleOwner){ isAuthorized ->
            if (!isAuthorized){
                navigationApi.navigate(ChatsDirections.ToAuthorization)
            }
            else{
                //request for user's chats
                //хардкод
                val items = mutableListOf<StringId>(
                    ChatsItem(chatsId = 1,
                        companionName = "Иван Самойлов",
                        lastMessage = "Как сам?",
                        avatar = BitmapFactory.decodeResource(resources, R.drawable.img)),
                    ChatsItem(chatsId = 2,
                        companionName = "Андрей Зайцев",
                        lastMessage = "Все собрались, ты где?",
                        avatar = BitmapFactory.decodeResource(resources, R.drawable.img)),
                    ChatsItem(chatsId = 3,
                        companionName = "Кирилл Горов",
                        lastMessage = "Почему не отвечаешь, случилось что?",
                        avatar = BitmapFactory.decodeResource(resources, R.drawable.img))
                )
                itemsAdapter.submitList(items)
            }
        }
    }

    private fun init() {
        viewModel = ViewModelProvider(this, chatsViewModelFactory)[ChatsViewModel::class]
        viewModel.checkAuth()
        recycler = binding.chats
        itemsAdapter = BaseRecyclerAdapter(viewHoldersManager, CustomItemClickListener {id, chatsId, type ->
            navigationApi.navigate(ChatsDirections.ToDialog(ChatsToDialogArgs(chatsId!!)))
        })
        recycler.apply {
            val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            layoutManager = manager
            addItemDecoration(DividerItemDecoration(
                recycler.context,
                manager.orientation
            ))
            adapter = itemsAdapter
        }
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

    private fun setClickListeners() {

    }
}