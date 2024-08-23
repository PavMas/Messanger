package com.trifcdr.chats.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.usecase.CheckAuthorizedUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ChatsViewModel @Inject constructor(
    private val checkAuthorizedUseCase: CheckAuthorizedUseCase
) : ViewModel() {

    private val resultAuthMutable = MutableLiveData<Boolean>()
    val resultAuth: LiveData<Boolean>
        get() = resultAuthMutable

    fun checkAuth() = viewModelScope.launch{
        var res = false
        viewModelScope.launch(Dispatchers.IO){
            res = checkAuthorizedUseCase.execute()
        }.join()
        resultAuthMutable.value = res
    }
}