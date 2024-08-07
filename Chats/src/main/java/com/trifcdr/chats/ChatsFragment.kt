package com.trifcdr.chats

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trifcdr.chats.databinding.FragmentChatsBinding
import com.trifcdr.chats.di.ChatsComponentHolder
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ChatsFragment : Fragment() {

    private lateinit var binding: FragmentChatsBinding

    @Inject
    lateinit var navigationApi: NavigationApi<ChatsDirections>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentChatsBinding.inflate(inflater, container, false)
        setClickListeners()
        return binding.root
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