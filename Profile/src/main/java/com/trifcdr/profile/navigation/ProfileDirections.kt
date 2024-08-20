package com.trifcdr.profile.navigation

/**
 * Created by trifcdr.
 */
interface ProfileDirections {

    data class ToProfileEdit(val profileEditArgs: ProfileToEditArgs): ProfileDirections

    data object ToProfile: ProfileDirections

    data object ToAuthorization: ProfileDirections
}