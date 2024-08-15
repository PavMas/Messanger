package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.repository.AuthorizationRepository
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class CheckAuthCodeUseCase @Inject constructor (private val authRepo: AuthorizationRepository) {

    suspend fun execute(phone: String, code: String): DomainResource<AuthData> {
        return authRepo.checkAuthCode(phone, code)
    }
}