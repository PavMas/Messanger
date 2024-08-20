package com.trifcdr.chats.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trifcdr.chats.databinding.FragmentChatsBinding
import com.trifcdr.chats.di.ChatsComponentHolder
import com.trifcdr.chats.navigation.ChatsDirections
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
    lateinit var authViewModelFactory: ChatsViewModelFactory

    @Inject
    lateinit var navigationApi: NavigationApi<ChatsDirections>

    private lateinit var viewModel: ChatsViewModel


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
            if (isAuthorized){
                navigationApi.navigate(ChatsDirections.ToAuthorization)
            }
            else{
                //request for user's chats
            }
        }
    }

    private fun init() {
        viewModel = ViewModelProvider(this, authViewModelFactory)[ChatsViewModel::class]
        viewModel.checkAuth()
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