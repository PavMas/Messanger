package com.trifcdr.domain.repository

import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser

/**
 * Created by trifcdr.
 */
interface RegistrationRepository {

    suspend fun registerUser(user: RegisterUser): DomainResource<RegisterData>

}