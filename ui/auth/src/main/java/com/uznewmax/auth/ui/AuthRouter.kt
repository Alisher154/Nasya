package com.uznewmax.auth.ui

import com.github.terrakok.cicerone.Router
import com.uznewmax.home.HomeScreens
import javax.inject.Inject

/**
 * Created by Alisher Kazakbaev on 26.06.2022.
 */
internal class AuthRouter @Inject constructor(
    private val router: Router
) : AuthContract.Router {
    override suspend fun navigateToHome() {
        router.navigateTo(HomeScreens.HomeScreen())
    }

    override suspend fun finish() {
        router.exit()
    }
}