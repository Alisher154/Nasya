package com.uznewmax.auth.di

import com.uznewmax.auth.ui.AuthContract
import com.uznewmax.auth.ui.AuthRouter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent


@[Module InstallIn(ActivityRetainedComponent::class)]
internal interface NavigationBindModule {

    @[Binds]
    fun bindHomeRouter(binder: AuthRouter): AuthContract.Router
}