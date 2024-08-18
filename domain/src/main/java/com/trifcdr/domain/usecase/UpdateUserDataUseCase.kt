package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileDataRequest
import com.trifcdr.domain.repository.ProfileRepository
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class UpdateUserDataUseCase @Inject constructor(
    private val repository: ProfileRepository,
) {

    suspend fun execute(data: ProfileDataRequest): DomainResource<Boolean> {
        return repository.updateProfileData(data)
    }

}