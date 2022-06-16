package com.uznewmax.auth.usecase.validation

sealed class ValidationResult {
    object Success : ValidationResult()
    data class Error(val message: String): ValidationResult()
}
