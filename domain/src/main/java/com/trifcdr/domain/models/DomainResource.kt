package com.trifcdr.domain.models

/**
 * Created by trifcdr.
 */
sealed class DomainResource<out R> {
    data object Unauthorized : DomainResource<Nothing>()
    data object Forbidden : DomainResource<Nothing>()
    data object Empty : DomainResource<Nothing>()

    data class Success<out R>(val result: R) : DomainResource<R>()
    data class Failure(val exception: Exception) : DomainResource<Nothing>()
}