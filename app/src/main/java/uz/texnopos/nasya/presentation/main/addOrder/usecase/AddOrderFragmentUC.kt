package uz.texnopos.nasya.presentation.main.addOrder.usecase

import uz.texnopos.nasya.data.local.room.entities.Order

interface AddOrderFragmentUC {
    suspend fun addOrder(order: Order)
}