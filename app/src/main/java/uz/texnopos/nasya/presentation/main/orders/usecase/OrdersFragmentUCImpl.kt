package uz.texnopos.nasya.presentation.main.orders.usecase

import uz.texnopos.nasya.repository.interfaces.ClientsRepository
import javax.inject.Inject

class OrdersFragmentUCImpl @Inject constructor(private val repo: ClientsRepository) :
    OrdersFragmentUC {
    override suspend fun removeClient(clientId: Int) {
        repo.removeClient(clientId)
    }

}