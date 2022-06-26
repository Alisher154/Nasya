package com.uznewmax.auth.ui

/**
 * Created by Alisher Kazakbaev on 26.06.2022.
 */
internal interface AuthContract {

    interface ViewModel {
        fun onBackPressed()
    }

    interface Router {
        suspend fun navigateToHome()
        suspend fun finish()
    }
}