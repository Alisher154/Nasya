@file:Suppress("FunctionName")
package com.uznewmax.home.ui

import com.github.terrakok.cicerone.androidx.FragmentScreen

/**
 * Created by Alisher Kazakbaev on 26.06.2022.
 */
object HomeScreens {

    fun HomeScreen(): FragmentScreen = FragmentScreen {
        HomeFragment()
    }
}