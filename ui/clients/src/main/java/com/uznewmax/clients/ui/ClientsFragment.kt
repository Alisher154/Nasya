package com.uznewmax.clients.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.uznewmax.clients.ui.databinding.FragmentClientsBinding
import com.uznewmax.clients.viewmodel.ClientsVMImpl
import com.uznewmax.core.utils.State
import com.uznewmax.core.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ClientsFragment : Fragment(R.layout.fragment_clients) {

    private val binding by viewBinding(FragmentClientsBinding::bind)
    private val viewModel by viewModels<ClientsVMImpl>()
    private val adapter = ClientsAdapter()
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        navController = Navigation.findNavController(requireActivity(), R.id.fcvMain)
        observe()
        binding.apply {
            rvClients.adapter = adapter
            adapter.onItemClick {
//                val action = MainFragmentDirections.actionMainFragmentToOrdersFragment(it)
//                navController.navigate(action)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        viewModel.getAllClients()
    }

    private fun observe() {
        viewModel.clients.observe(viewLifecycleOwner) {
            when (it) {
                State.LoadingState -> {

                }
                is State.SuccessState -> {
                    adapter.setData(it.data)
                }
                is State.ErrorState -> {
                    toast(it.exception.localizedMessage ?: "Something wrong")
                }


            }
        }
    }
}
