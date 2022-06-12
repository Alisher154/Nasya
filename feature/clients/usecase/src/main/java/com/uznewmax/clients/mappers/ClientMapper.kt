package com.uznewmax.clients.mappers

import com.uznewmax.clients.api.entities.ClientEntity
import com.uznewmax.clients.models.Client
import com.uznewmax.core.mapper.SingleMapper

/**
 * Created by Alisher Kazakbaev on 12.06.2022.
 */
object ClientMapper : SingleMapper<ClientEntity, Client> {
    override fun invoke(value: ClientEntity): Client {
        return Client(
            id = value.id,
            fullName = value.fullName,
            documentNumber = value.documentNumber
        )
    }
}