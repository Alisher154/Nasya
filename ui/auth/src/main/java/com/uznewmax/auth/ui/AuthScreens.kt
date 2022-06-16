@file:Suppress("FunctionName")

package com.uznewmax.auth.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen

object AuthScreens {

    fun LoginScreen(): FragmentScreen = FragmentScreen {
        LoginFragment()
    }
}