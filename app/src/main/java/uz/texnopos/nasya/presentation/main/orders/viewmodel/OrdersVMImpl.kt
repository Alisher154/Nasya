package uz.texnopos.nasya.presentation.main.orders.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.texnopos.nasya.presentation.main.orders.usecase.OrdersFragmentUC
import javax.inject.Inject

@HiltViewModel
class OrdersVMImpl @Inject constructor(private val useCase: OrdersFragmentUC) : ViewModel(),
    OrdersVM {
    override fun deleteClientById(clientId: Int) {
        viewModelScope.launch {
            useCase.removeClient(clientId)
        }
    }

}