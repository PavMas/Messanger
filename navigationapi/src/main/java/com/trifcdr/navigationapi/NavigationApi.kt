package com.trifcdr.navigationapi

interface NavigationApi <DIRECTION> {

    fun navigate(direction: DIRECTION)
}