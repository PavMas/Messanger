package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.domain.repository.RegistrationRepository
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class RegisterUserUseCase @Inject constructor (private val regRepo: RegistrationRepository) {

    suspend fun execute(user: RegisterUser): DomainResource<RegisterData> {
        return regRepo.registerUser(user)
    }
}