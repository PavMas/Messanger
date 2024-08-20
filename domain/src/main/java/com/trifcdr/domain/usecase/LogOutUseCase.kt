package com.trifcdr.domain.usecase

import com.trifcdr.domain.repository.ProfileRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val repository: ProfileRepository
) {

    suspend fun execute(): Boolean {
        return repository.logout()
    }

}