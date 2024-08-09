package com.trifcdr.authorization

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.trifcdr.navigationimpl.R

public class AuthorizationFragmentDirections private constructor() {
  public companion object {
    public fun fromAuthToRegister(): NavDirections =
        ActionOnlyNavDirections(R.id.from_auth_to_register)

    public fun fromAuthToChats(): NavDirections = ActionOnlyNavDirections(R.id.from_auth_to_chats)
  }
}
