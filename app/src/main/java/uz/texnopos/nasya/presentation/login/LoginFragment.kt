package uz.texnopos.nasya.presentation.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentLoginBinding
import uz.texnopos.nasya.utils.onClick

class LoginFragment : Fragment(R.layout.fragment_login) {

    private val binding by viewBinding(FragmentLoginBinding::bind)
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding.apply {
            btnLogin.onClick {
                navController.navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }
    }
}