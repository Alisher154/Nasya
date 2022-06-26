package com.uznewmax.auth.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uznewmax.auth.usecase.validation.ValidateMail
import com.uznewmax.auth.usecase.validation.ValidatePassword
import com.uznewmax.auth.usecase.validation.ValidationResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by Alisher Kazakbaev on 06.06.2022.
 */

@HiltViewModel
internal class LoginViewModel @Inject constructor(
    private val validateMail: ValidateMail,
    private val validatePassword: ValidatePassword,
    private val router: AuthContract.Router
) : ViewModel(), AuthContract.ViewModel {


    private val _event = Channel<RegisterEvent>()
    val event: Flow<RegisterEvent> = _event.receiveAsFlow()

    private fun safelyValidate(execution: () -> Unit) {
        try {
            execution()
        } catch (e: ValidationException) {
        }
    }

    private fun onValidateMail(email: String) {
        val result = validateMail(email)
        if (result is ValidationResult.Error) {
            viewModelScope.launch {
                _event.send(RegisterEvent.Empty(result.message))
            }
            throw ValidationException()
        }
    }

    private fun onValidatePassword(password: String) {
        val result = validatePassword(password)
        if (result is ValidationResult.Error) {
            viewModelScope.launch {
                _event.send(RegisterEvent.Empty(result.message))
            }
            throw ValidationException()
        }
    }

    fun register(email: String, password: String) {
        safelyValidate {
            onValidateMail(email)
            onValidatePassword(password)
            viewModelScope.launch {
                _event.send(RegisterEvent.Success)
                router.navigateToHome()
            }
        }
    }


    sealed class RegisterEvent {
        object Success : RegisterEvent()
        data class Empty(var message: String) : RegisterEvent()
    }

    class ValidationException : RuntimeException()

    override fun onBackPressed() {
        viewModelScope.launch { router.finish() }
    }

}