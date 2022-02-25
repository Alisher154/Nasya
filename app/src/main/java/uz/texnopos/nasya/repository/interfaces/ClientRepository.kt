package uz.texnopos.nasya.repository.interfaces

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client

interface ClientRepository {

    suspend fun clientRegister(client: Client)

    fun getAllClients(): Flow<List<Client>>

    suspend fun removeClient(id: Int)

}