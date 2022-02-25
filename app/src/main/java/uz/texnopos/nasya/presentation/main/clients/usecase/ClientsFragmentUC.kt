package uz.texnopos.nasya.presentation.main.clients.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client

interface ClientsFragmentUC {
    fun getAllClients(): Flow<List<Client>>
}