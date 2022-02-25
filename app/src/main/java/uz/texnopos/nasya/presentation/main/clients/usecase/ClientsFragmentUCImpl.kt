package uz.texnopos.nasya.presentation.main.clients.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.repository.interfaces.ClientsRepository
import uz.texnopos.nasya.utils.showLogD
import javax.inject.Inject

class ClientsFragmentUCImpl @Inject constructor(private val repo: ClientsRepository) :
    ClientsFragmentUC {
    override fun getAllClients(): Flow<List<Client>> {
        return repo.getAllClients()
    }
}