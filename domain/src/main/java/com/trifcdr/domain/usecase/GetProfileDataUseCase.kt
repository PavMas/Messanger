package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.repository.ProfileRepository
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class GetProfileDataUseCase @Inject constructor(
    private val repository: ProfileRepository
) {

    suspend fun execute(): DomainResource<ProfileData> {
        return repository.getProfileData()
    }

}