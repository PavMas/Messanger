package com.trifcdr.domain.repository

interface ChatsRepository {

    suspend fun isAuthorized(): Boolean
}