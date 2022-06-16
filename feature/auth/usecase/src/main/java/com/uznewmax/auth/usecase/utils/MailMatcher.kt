package com.uznewmax.auth.usecase.utils

interface MailMatcher {

    fun matches(mail: String): Boolean
}