package uz.texnopos.nasya.presentation.main.addClient.phone

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentMultiPhoneBinding
import uz.texnopos.nasya.utils.onClick

class MultiPhoneFragment : Fragment(R.layout.fragment_multi_phone) {
    private lateinit var bind: FragmentMultiPhoneBinding

    private val adapter = PhoneAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bind = FragmentMultiPhoneBinding.bind(view).apply {
            rvPhones.adapter = adapter
            addBtn.onClick {
                adapter.add()
            }
        }
    }
}