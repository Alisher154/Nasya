package uz.texnopos.nasya.presentation.main.clients.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.repository.interfaces.ClientRepository
import javax.inject.Inject

class ClientsFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    ClientsFragmentUC {
    override fun getAllClients(): Flow<List<Client>> {
        return repo.getAllClients()
    }
}