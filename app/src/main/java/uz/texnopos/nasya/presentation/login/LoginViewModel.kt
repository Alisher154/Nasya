package uz.texnopos.nasya.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import uz.texnopos.nasya.domain.usecase.validation.ValidateMail
import uz.texnopos.nasya.domain.usecase.validation.ValidatePassword
import uz.texnopos.nasya.domain.usecase.validation.ValidationResult
import javax.inject.Inject

/**
 * Created by Alisher Kazakbaev on 06.06.2022.
 */

//@HiltViewModel
//class LoginViewModel @Inject constructor(
//    private val validateMail: ValidateMail,
//    private val validatePassword: ValidatePassword,
//) : ViewModel() {
//

//    private val _event = Channel<RegisterEvent>()
//    val event: Flow<RegisterEvent> = _event.receiveAsFlow()
//
//    private fun safelyValidate(execution: () -> Unit) {
//        try {
//            execution()
//        } catch (e: ValidationException) {
//        }
//    }
//
//    private fun onValidateMail(email: String) {
//        val result = validateMail(email)
//        if (result is ValidationResult.Error) {
//            viewModelScope.launch {
//                _event.send(RegisterEvent.Empty(result.message))
//            }
//            throw ValidationException()
//        }
//    }
//
//    private fun onValidatePassword(password: String) {
//        val result = validatePassword(password)
//        if (result is ValidationResult.Error) {
//            viewModelScope.launch {
//                _event.send(RegisterEvent.Empty(result.message))
//            }
//            throw ValidationException()
//        }
//    }
//
//    fun register(email: String, password: String) {
//        safelyValidate {
//            onValidateMail(email)
//            onValidatePassword(password)
//            viewModelScope.launch { _event.send(RegisterEvent.Success) }
//        }
//    }
//
//
//    sealed class RegisterEvent {
//        object Success : RegisterEvent()
//        data class Empty(var message: String) : RegisterEvent()
//    }
//
//    class ValidationException : RuntimeException()

//}