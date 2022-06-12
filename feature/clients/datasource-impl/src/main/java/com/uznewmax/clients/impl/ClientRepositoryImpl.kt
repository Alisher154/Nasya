package com.uznewmax.clients.impl

import com.uznewmax.clients.api.ClientRepository
import com.uznewmax.clients.api.entities.ClientEntity
import com.uznewmax.clients.database.ClientsDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ClientRepositoryImpl @Inject constructor(private val dao: ClientsDao) : ClientRepository {

    override fun getAllClients(): Flow<List<ClientEntity>> {
        return dao.getAllClients()
    }

}