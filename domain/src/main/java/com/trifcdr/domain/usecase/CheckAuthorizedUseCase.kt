package com.trifcdr.domain.usecase

import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.domain.repository.ChatsRepository
import javax.inject.Inject

class CheckAuthorizedUseCase @Inject constructor (private val chatsRepo: ChatsRepository) {

    suspend fun execute(): Boolean {
        return chatsRepo.isAuthorized()
    }
}