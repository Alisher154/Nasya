package com.uznewmax.auth.usecase.validation

class ValidatePassword {

    companion object {
        private const val MINIMUM_LENGTH = 8
    }

    operator fun invoke(password: String): ValidationResult {
        return when {
            lessThanMinimum(password) -> ValidationResult.Error("Please write at least 4 length of password")
            notContainsLetter(password) -> ValidationResult.Error("Please contain at least a letter in your password")
            notContainsDigit(password) -> ValidationResult.Error("Please contain at least a digit in your password")
            else -> ValidationResult.Success
        }
    }

    private fun lessThanMinimum(password: String): Boolean {
        return password.length < MINIMUM_LENGTH
    }

    private fun notContainsLetter(password: String): Boolean {
        return !password.any { it.isLetter() }
    }

    private fun notContainsDigit(password: String): Boolean {
        return !password.any { it.isDigit() }
    }
}