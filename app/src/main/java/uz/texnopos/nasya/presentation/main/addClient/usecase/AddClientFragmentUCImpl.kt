package uz.texnopos.nasya.presentation.main.addClient.usecase

import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.domain.repository.ClientRepository
import javax.inject.Inject

class AddClientFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    AddClientFragmentUC {
    override suspend fun clientRegister(client: Client) {
        repo.clientRegister(client)
    }

}