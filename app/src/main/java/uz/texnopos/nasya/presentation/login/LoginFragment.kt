package uz.texnopos.nasya.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentLoginBinding
import uz.texnopos.nasya.utils.onClick
import uz.texnopos.nasya.utils.textToString
import uz.texnopos.nasya.utils.toast

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private lateinit var navController: NavController
    private val viewModel by viewModels<LoginViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
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
                        navController.navigate(R.id.action_loginFragment_to_mainFragment)
                    }
                }
            }
        }

    }
}