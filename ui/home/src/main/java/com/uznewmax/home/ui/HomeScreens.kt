@file:Suppress("FunctionName")

package com.uznewmax.home.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen

object HomeScreens {

    fun HomeScreen(): FragmentScreen = FragmentScreen {
        HomeFragment()
    }
}