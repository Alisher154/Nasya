package com.uznewmax.clients.usecase

import com.uznewmax.clients.api.ClientRepository
import com.uznewmax.clients.mappers.ClientMapper
import com.uznewmax.clients.models.Client
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ClientsUC(private val repo: ClientRepository) {
    operator fun invoke(): Flow<List<Client>> {
        return repo.getAllClients().map { clients ->
            clients.map { ClientMapper.invoke(it) }
        }
    }
}