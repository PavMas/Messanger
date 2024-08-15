package com.trifcdr.registration.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.domain.usecase.RegisterUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class RegistrationViewModel @Inject constructor(
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    private val resultRegisterUserMutable = MutableLiveData<DomainResource<RegisterData>>()
    val resultRegisterUser: LiveData<DomainResource<RegisterData>>
        get() = resultRegisterUserMutable


    fun registerUser(user: RegisterUser) = viewModelScope.launch {
        var res: DomainResource<RegisterData> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = registerUserUseCase.execute(user)
        }.join()
        resultRegisterUserMutable.value = res
    }

}