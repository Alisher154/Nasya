package uz.texnopos.nasya.presentation.main.addClient.usecase

import uz.texnopos.nasya.data.local.room.entities.Client

interface AddClientFragmentUC {
    suspend fun clientRegister(client: Client)
}