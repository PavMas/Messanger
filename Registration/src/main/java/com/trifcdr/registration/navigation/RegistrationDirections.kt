package com.trifcdr.registration.navigation

/**
 * Created by trifcdr.
 */
sealed interface RegistrationDirections {

    object ToAuthorization: RegistrationDirections
}