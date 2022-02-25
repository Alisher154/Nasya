package uz.texnopos.nasya.presentation.main.orders

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.PopupMenu
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.databinding.FragmentOrdersBinding
import uz.texnopos.nasya.presentation.main.orders.viewmodel.OrdersVMImpl
import uz.texnopos.nasya.utils.onClick

@AndroidEntryPoint
class OrdersFragment : Fragment(R.layout.fragment_orders) {

    private val binding by viewBinding(FragmentOrdersBinding::bind)
    private lateinit var navController: NavController
    private val viewModel by viewModels<OrdersVMImpl>()
    private lateinit var client: Client
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        client=arguments?.let { OrdersFragmentArgs.fromBundle(it).client }!!
        navController = Navigation.findNavController(requireActivity(), R.id.fcvMain)
        binding.apply {
            tvFullName.text=client.fullName
            tvClientId.text=getString(R.string.client_id,client.id)
            toolbar.setNavigationOnClickListener {
                requireActivity().onBackPressed()
            }
            btnFab.onClick {
                navController.navigate(R.id.action_ordersFragment_to_addOrderFragment)
            }
            toolbar.menu[0].setOnMenuItemClickListener {
                showOptionsDialog(toolbar.findViewById(R.id.options))
                true
            }
        }
    }

    private fun showOptionsDialog(view: View) {
        val popup = PopupMenu(requireContext(), view)
        popup.inflate(R.menu.menu_orders_operations)
        popup.gravity = Gravity.CENTER
        popup.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_delete_client -> {
                    showDeleteValidationDialog(client)
                    true
                }
                else -> false
            }
        }
        popup.show()
    }

    private fun showDeleteValidationDialog(client: Client) {
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .apply {
                setTitle("Delete")
                setMessage(client.fullName)
                setPositiveButton("Delete") { _, _ ->
                    viewModel.deleteClientById(client.id ?: -1)
                    requireActivity().onBackPressed()
                }
                setNeutralButton("Cancel") { dialog, _ ->
                    dialog.dismiss()
                }
                create()
                show()
            }
    }

}