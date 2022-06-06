package uz.texnopos.nasya.presentation.main.addOrder.usecase

import uz.texnopos.nasya.data.local.room.entities.Order
import uz.texnopos.nasya.domain.repository.ClientRepository
import javax.inject.Inject

class AddOrderFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    AddOrderFragmentUC {
    override suspend fun addOrder(order: Order) {
        repo.addOrder(order)
    }

}