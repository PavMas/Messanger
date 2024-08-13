package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.repository.AuthorizationRepository
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class SendAuthCodeUseCase @Inject constructor (private val authRepo: AuthorizationRepository) {

    suspend fun execute(phone: String): DomainResource<AuthCode>{
        return authRepo.sendAuthCode(phone)
    }
}