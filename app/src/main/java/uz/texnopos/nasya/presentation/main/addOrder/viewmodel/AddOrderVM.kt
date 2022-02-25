package uz.texnopos.nasya.presentation.main.addOrder.viewmodel

import androidx.lifecycle.LiveData
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.data.local.room.entities.Order
import uz.texnopos.nasya.utils.State

interface AddOrderVM {
    fun addOrder(client: Order)
}