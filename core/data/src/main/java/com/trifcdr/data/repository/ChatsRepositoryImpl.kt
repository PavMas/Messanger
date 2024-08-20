package com.trifcdr.data.repository

import com.trifcdr.domain.repository.ChatsRepository
import com.trifcdr.storage.AppStorage
import javax.inject.Inject

class ChatsRepositoryImpl @Inject constructor(
    private val storage: AppStorage
) : ChatsRepository {

    override suspend fun isAuthorized(): Boolean {
        return storage.isAuthorized()
    }

}