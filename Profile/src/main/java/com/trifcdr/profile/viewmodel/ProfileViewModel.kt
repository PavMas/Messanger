package com.trifcdr.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.models.ProfileDataRequest
import com.trifcdr.domain.usecase.GetProfileDataUseCase
import com.trifcdr.domain.usecase.LogOutUseCase
import com.trifcdr.domain.usecase.UpdateUserDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ProfileViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase,
    private val updateUserDataUseCase: UpdateUserDataUseCase,
    private val logOutUseCase: LogOutUseCase
): ViewModel() {
    private val resultProfileDataMutable = MutableLiveData<DomainResource<ProfileData>>()
    val resultProfileData: LiveData<DomainResource<ProfileData>>
        get() = resultProfileDataMutable

    private val resultUpdateUserDataMutable = MutableLiveData<DomainResource<Boolean>>()
    val resultUpdateUserData: LiveData<DomainResource<Boolean>>
        get() = resultUpdateUserDataMutable

    private val resultClearUserDataMutable = MutableLiveData<Boolean>()
    val resultClearUserData: LiveData<Boolean>
        get() = resultClearUserDataMutable


    fun getProfileData() = viewModelScope.launch {
        var res: DomainResource<ProfileData> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = getProfileDataUseCase.execute()
        }.join()
        resultProfileDataMutable.value = res
    }

    fun updateUserData(data: ProfileDataRequest) = viewModelScope.launch {
        var res: DomainResource<Boolean> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = updateUserDataUseCase.execute(data)
        }.join()
        resultUpdateUserDataMutable.value = res
    }

    fun cleanUserData() = viewModelScope.launch {
        var res: Boolean = false
        viewModelScope.launch(Dispatchers.IO) {
            res = logOutUseCase.execute()
        }.join()
        resultClearUserDataMutable.value = res
    }
}