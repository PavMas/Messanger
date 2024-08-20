package com.trifcdr.domain.repository

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.models.ProfileDataRequest

/**
 * Created by trifcdr.
 */
interface ProfileRepository {

    suspend fun getProfileData(): DomainResource<ProfileData>

    suspend fun updateProfileData(data: ProfileDataRequest): DomainResource<Boolean>

    suspend fun logout(): Boolean

}