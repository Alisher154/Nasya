package uz.texnopos.nasya.presentation.main.orders.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client

interface OrdersFragmentUC {
    suspend fun removeClient(clientId:Int)
}