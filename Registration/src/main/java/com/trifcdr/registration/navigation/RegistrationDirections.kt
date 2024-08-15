package com.trifcdr.registration.navigation

/**
 * Created by trifcdr.
 */
sealed interface RegistrationDirections {

    data object ToAuthorization: RegistrationDirections
}