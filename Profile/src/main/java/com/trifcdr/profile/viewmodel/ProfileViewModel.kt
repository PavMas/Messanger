package com.trifcdr.profile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.usecase.GetProfileDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ProfileViewModel @Inject constructor(
    private val getProfileDataUseCase: GetProfileDataUseCase
): ViewModel() {
    private val resultProfileDataMutable = MutableLiveData<DomainResource<ProfileData>>()
    val resultProfileData: LiveData<DomainResource<ProfileData>>
        get() = resultProfileDataMutable


    fun getProfileData() = viewModelScope.launch {
        var res: DomainResource<ProfileData> = DomainResource.Empty
        viewModelScope.launch(Dispatchers.IO) {
            res = getProfileDataUseCase.execute()
        }.join()
        resultProfileDataMutable.value = res
    }
}