package com.uznewmax.auth.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uznewmax.auth.ui.databinding.FragmentLoginBinding
import com.uznewmax.core.utils.onClick
import com.uznewmax.core.utils.textToString
import com.uznewmax.core.utils.toast
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupEvents()
        binding.apply {
            btnLogin.onClick {
                val email = etLogin.textToString()
                val password = etPassword.textToString()
                viewModel.register(email, password)
            }
        }
    }

    private fun setupEvents() {
        lifecycleScope.launch {
            viewModel.event.collectLatest { event ->
                when (event) {
                    is LoginViewModel.RegisterEvent.Empty -> {
                        toast(event.message)
                    }
                    LoginViewModel.RegisterEvent.Success -> {
                        toast(R.string.successful_registered)
                    }
                }
            }
        }

    }
}