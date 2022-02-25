package uz.texnopos.nasya.presentation.main.clients

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentClientsBinding
import uz.texnopos.nasya.presentation.main.MainFragmentDirections
import uz.texnopos.nasya.presentation.main.clients.viewmodel.ClientsVMImpl
import uz.texnopos.nasya.utils.State
import uz.texnopos.nasya.utils.toast

@AndroidEntryPoint
class ClientsFragment : Fragment(R.layout.fragment_clients) {

    private val binding by viewBinding(FragmentClientsBinding::bind)
    private val viewModel by viewModels<ClientsVMImpl>()
    private val adapter = ClientsAdapter()
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(requireActivity(), R.id.fcvMain)
        observe()
        binding.apply {
            rvClients.adapter = adapter
            adapter.onItemClick {
                val action = MainFragmentDirections.actionMainFragmentToOrdersFragment(it)
                navController.navigate(action)
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
