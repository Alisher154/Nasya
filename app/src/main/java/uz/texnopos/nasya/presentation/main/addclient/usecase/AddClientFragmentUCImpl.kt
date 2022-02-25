package uz.texnopos.nasya.presentation.main.addclient.usecase

import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.repository.interfaces.ClientRepository
import javax.inject.Inject

class AddClientFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    AddClientFragmentUC {
    override suspend fun clientRegister(client: Client) {
        repo.clientRegister(client)
    }

}