package com.trifcdr.domain.repository

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.DomainResource

/**
 * Created by trifcdr.
 */
interface AuthorizationRepository {

    suspend fun sendAuthCode(phone: String): DomainResource<AuthCode>
}