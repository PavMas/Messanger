package com.trifcdr.data.mapper

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.domain.models.RegisterData
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthDataModel
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