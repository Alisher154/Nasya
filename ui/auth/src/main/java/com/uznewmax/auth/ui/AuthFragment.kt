package com.uznewmax.auth.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uznewmax.auth.ui.databinding.FragmentAuthBinding


class AuthFragment : Fragment(R.layout.fragment_auth) {
    private val binding by viewBinding(FragmentAuthBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnSignIn.setOnClickListener {

            }
        }
    }
}