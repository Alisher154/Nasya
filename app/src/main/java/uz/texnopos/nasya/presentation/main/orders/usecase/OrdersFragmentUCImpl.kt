package uz.texnopos.nasya.presentation.main.orders.usecase

import uz.texnopos.nasya.domain.repository.ClientRepository
import javax.inject.Inject

class OrdersFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    OrdersFragmentUC {
    override suspend fun removeClient(clientId: Int) {
        repo.removeClient(clientId)
    }

}