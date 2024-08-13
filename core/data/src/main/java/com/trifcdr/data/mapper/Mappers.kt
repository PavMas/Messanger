package com.trifcdr.data.mapper

import com.trifcdr.domain.models.AuthCode
import com.trifcdr.network.model.AuthCodeModel

/**
 * Created by trifcdr.
 */

fun mapAuthCodeToDomain(res: AuthCodeModel): AuthCode{
    return AuthCode(res.isSuccess)
}