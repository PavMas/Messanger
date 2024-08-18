package com.trifcdr.data.mapper

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.domain.models.ProfileDataRequest
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthDataModel
import com.trifcdr.network.model.Avatar
import com.trifcdr.network.model.ProfileDataModel
import com.trifcdr.network.model.RegisterUserDataModel
import com.trifcdr.network.model.RegisterUserRequestModule
import com.trifcdr.network.model.SaveUserDataRequestModel
import com.trifcdr.storage.model.UserData

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

fun mapUserDataToStorage(res: ProfileDataModel): UserData{
    val data = res.profileData
    return UserData(
        id = data.id,
        name = data.name,
        username = data.username,
        city = data.city!!,
        birthday = data.birthday!!,
        phone = data.phone,
        vk = data.vk!!,
        instagram = data.instagram!!,
        status = data.status!!,
        avatar = data.avatar ?: ""
    )
}

fun mapUserDataToStorage(res: ProfileDataRequest): UserData{
    return UserData(
        name = res.name,
        city = res.city,
        birthday = res.birthday,
        vk = res.vk,
        instagram = res.instagram,
        status = res.status,
        avatar = res.avatar?.base64 ?: ""
    )
}

fun mapUpdateDataToData(newData: ProfileDataRequest): SaveUserDataRequestModel{
    var avatar: Avatar? = null
    if (newData.avatar != null){
        avatar = Avatar(
            newData.avatar!!.fileName,
            newData.avatar!!.base64
        )
    }
    return SaveUserDataRequestModel(
        name = newData.name,
        username = newData.username,
        birthday = newData.birthday,
        city = newData.city,
        vk = newData.vk,
        instagram = newData.instagram,
        status = newData.status,
        avatar = avatar
    )
}

fun mapUserStorageDataToDomain(data: UserData): ProfileDataModel{
    return ProfileDataModel(
        com.trifcdr.network.model.ProfileData(
            id = data.id!!,
            phone = data.phone!!,
            name = data.name!!,
            username = data.username!!,
            birthday = data.birthday,
            city = data.city,
            vk = data.vk,
            instagram = data.instagram,
            status = data.status,
            avatar = data.avatar,
            created = data.created,
            online = null,
            last = data.last,
            completedTask = 0
        )
    )
}