package com.trifcdr.data.mapper

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.domain.models.AuthData
import com.trifcdr.network.model.AuthCodeModel
import com.trifcdr.network.model.AuthDataModel

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