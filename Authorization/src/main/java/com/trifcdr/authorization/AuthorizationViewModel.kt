package com.trifcdr.authorization

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.domain.usecase.SendAuthCodeUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */


class AuthorizationViewModel @Inject constructor(
    private val sendAuthCodeUseCase: SendAuthCodeUseCase
): ViewModel() {

    private var resultSendCodeMutable = MutableLiveData<DomainResource<AuthCode>>()
    val resultSendCode: LiveData<DomainResource<AuthCode>>
        get() = resultSendCodeMutable

    fun sendAuthCode(phone: String) = viewModelScope.launch {
        var res: DomainResource<AuthCode> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = sendAuthCodeUseCase.execute(phone)
        }.join()
        resultSendCodeMutable.value = res
    }


}