package com.trifcdr.domain.repository

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource

/**
 * Created by trifcdr.
 */
interface AuthorizationRepository {

    suspend fun sendAuthCode(phone: String): DomainResource<AuthCode>

    suspend fun checkAuthCode(phone: String, code: String): DomainResource<AuthData>
}