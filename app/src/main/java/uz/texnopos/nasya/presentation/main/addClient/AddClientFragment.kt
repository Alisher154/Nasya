package uz.texnopos.nasya.presentation.main.addClient

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.databinding.FragmentAddClientBinding
import uz.texnopos.nasya.presentation.main.addClient.viewmodel.AddClientVMImpl
import uz.texnopos.nasya.utils.*

@AndroidEntryPoint
class AddClientFragment : Fragment(R.layout.fragment_add_client) {

    private val binding by viewBinding(FragmentAddClientBinding::bind)
    private val viewModel by viewModels<AddClientVMImpl>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        observe()
        binding.apply {
            btnRegister.onClick {
                val fullName = etFullName.textToString()
                val documentNumber =
                    etPassportSeries.textToString() + etPassportNumber.textToString()
                if (validate()) {
                    viewModel.clientRegister(
                        Client(
                            fullName = fullName,
                            documentNumber = documentNumber
                        )
                    )
                    requireActivity().onBackPressed()
                }
            }
        }
    }
    private fun FragmentAddClientBinding.validate(): Boolean {
        return when {
            etFullName.checkIsEmpty() -> etFullName.showError(getString(R.string.required))
            etPassportSeries.checkIsEmpty() -> etPassportSeries.showError(getString(R.string.required))
            etPassportNumber.checkIsEmpty() -> etPassportNumber.showError(getString(R.string.required))
            etPassportNumber.length() != 7 -> etPassportNumber.showError("Требуется 7 цифр")

            else -> true
        }
    }
}