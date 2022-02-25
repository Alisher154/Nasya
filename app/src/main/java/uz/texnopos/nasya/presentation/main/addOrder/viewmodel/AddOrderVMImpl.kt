package uz.texnopos.nasya.presentation.main.addOrder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.texnopos.nasya.data.local.room.entities.Order
import uz.texnopos.nasya.presentation.main.addOrder.usecase.AddOrderFragmentUC
import javax.inject.Inject

@HiltViewModel
class AddOrderVMImpl @Inject constructor(private val useCase: AddOrderFragmentUC) : ViewModel(),
    AddOrderVM {
    override fun addOrder(order: Order) {

        viewModelScope.launch {
            useCase.addOrder(order)
        }

    }

}