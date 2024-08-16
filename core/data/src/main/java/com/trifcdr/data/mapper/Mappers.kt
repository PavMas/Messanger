package com.trifcdr.data.mapper

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthDataModel
import com.trifcdr.network.model.ProfileDataModel
import com.trifcdr.network.model.RegisterUserDataModel
import com.trifcdr.network.model.RegisterUserRequestModule

/**
 * Created by trifcdr.
 */

fun mapAuthCodeToDomain(res: AuthCodeModel): AuthCode{
    return AuthCode(res.isSuccess)
}

fun mapAuthDataToDomain(res: AuthDataModel): AuthData{
    return AuthData(
        userId = res.userId,
        isUserExist = res.isUserExist
    )
}

fun mapRegisterUserToData(user: RegisterUser): RegisterUserRequestModule{
    return RegisterUserRequestModule(
        phone = user.phone,
        name = user.name,
        username = user.username
    )
}

fun mapRegisterDataToDomain(res: RegisterUserDataModel): RegisterData{
    return RegisterData(
        userId = res.userId
    )
}

fun mapProfileDataToDomain(res: ProfileDataModel): ProfileData{
    val profileData = res.profileData
    return ProfileData(
        name = profileData.name,
        username = profileData.username,
        birthday = profileData.birthday,
        city = profileData.city,
        vk = profileData.vk,
        instagram = profileData.instagram,
        status = profileData.status,
        avatar = profileData.avatar,
        id = profileData.id,
        last = profileData.last,
        online = profileData.online,
        created = profileData.created,
        phone = profileData.phone
    )
}