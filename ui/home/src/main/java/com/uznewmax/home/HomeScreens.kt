@file:Suppress("FunctionName")
package com.uznewmax.home

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.uznewmax.home.ui.HomeFragment

/**
 * Created by Alisher Kazakbaev on 26.06.2022.
 */
object HomeScreens {

    fun HomeScreen(): FragmentScreen = FragmentScreen {
        HomeFragment()
    }
}