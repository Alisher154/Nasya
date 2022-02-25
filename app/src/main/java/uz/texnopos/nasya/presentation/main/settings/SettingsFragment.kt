package uz.texnopos.nasya.presentation.main.settings

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentSettingsBinding

class SettingsFragment : Fragment(R.layout.fragment_settings) {

    private lateinit var binding: FragmentSettingsBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
        binding = FragmentSettingsBinding.bind(view).apply {
            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.itemLogout -> {
                        confirmationDialog()
                        true
                    }
                    else -> false
                }
            }
        }
    }

    private fun confirmationDialog() {
        AlertDialog.Builder(requireContext())
            .apply {
                setCancelable(false)
                setTitle(getString(R.string.logout_title))
                setMessage(getString(R.string.supporting_text))
                setPositiveButton("Выйти") { _, _ ->
                    logOut()
                }
                setNeutralButton("Отмена") { dialog, _ ->
                    dialog.dismiss()
                }
                create()
                show()
            }
    }

    private fun logOut() {
        navController.navigate(R.id.loginFragment)
    }
}