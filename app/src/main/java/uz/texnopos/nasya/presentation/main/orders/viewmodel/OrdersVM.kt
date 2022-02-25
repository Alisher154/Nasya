package uz.texnopos.nasya.presentation.main.orders.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.utils.State

interface OrdersVM {
    fun deleteClientById(clientId:Int)
}