package com.uznewmax.clients.api

import com.uznewmax.clients.api.entities.ClientEntity
import kotlinx.coroutines.flow.Flow

interface ClientRepository {

    fun getAllClients(): Flow<List<ClientEntity>>

}