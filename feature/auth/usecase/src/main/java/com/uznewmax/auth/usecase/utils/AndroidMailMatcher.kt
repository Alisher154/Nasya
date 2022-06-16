package com.uznewmax.auth.usecase.utils

import android.util.Patterns

class AndroidMailMatcher : MailMatcher {

    override fun matches(mail: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(mail).matches()
    }
}