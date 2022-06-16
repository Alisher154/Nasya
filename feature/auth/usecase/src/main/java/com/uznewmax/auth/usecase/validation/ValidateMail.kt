package com.uznewmax.auth.usecase.validation

import com.uznewmax.auth.usecase.utils.MailMatcher


class ValidateMail(
    private val matcher: MailMatcher
) {

    operator fun invoke(mail: String): ValidationResult {
        return when {
            blank(mail) -> ValidationResult.Error("Please write your mail address")
            notMatches(mail) -> ValidationResult.Error("Please write proper mail address")
            else -> ValidationResult.Success
        }
    }

    private fun blank(mail: String): Boolean {
        return mail.isBlank()
    }

    private fun notMatches(mail: String): Boolean {
        return !matcher.matches(mail)
    }
}