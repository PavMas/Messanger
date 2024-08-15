package com.trifcdr.authorization.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.usecase.CheckAuthCodeUseCase
import com.trifcdr.domain.usecase.SendAuthCodeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */


class AuthorizationViewModel @Inject constructor(
    private val sendAuthCodeUseCase: SendAuthCodeUseCase,
    private val checkAuthCodeUseCase: CheckAuthCodeUseCase
): ViewModel() {

    private val resultSendCodeMutable = MutableLiveData<DomainResource<AuthCode>>()
    val resultSendCode: LiveData<DomainResource<AuthCode>>
        get() = resultSendCodeMutable

    private val resultCheckCodeMutable = MutableLiveData<DomainResource<AuthData>>()
    val resultCheckCode: LiveData<DomainResource<AuthData>>
        get() = resultCheckCodeMutable

    fun sendAuthCode(phone: String) = viewModelScope.launch {
        var res: DomainResource<AuthCode> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = sendAuthCodeUseCase.execute(phone)
        }.join()
        resultSendCodeMutable.value = res
    }

    fun checkAuthCode(phone: String, code: String) = viewModelScope.launch {
        var res: DomainResource<AuthData> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = checkAuthCodeUseCase.execute(phone, code)
        }.join()
        resultCheckCodeMutable.value = res
    }


}