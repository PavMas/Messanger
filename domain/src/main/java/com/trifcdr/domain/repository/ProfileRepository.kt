package com.trifcdr.domain.repository

import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData

/**
 * Created by trifcdr.
 */
interface ProfileRepository {

    suspend fun getProfileData(): DomainResource<ProfileData>

}