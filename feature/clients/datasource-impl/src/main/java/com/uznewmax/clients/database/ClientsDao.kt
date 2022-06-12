package com.uznewmax.clients.database

import androidx.room.Dao
import androidx.room.Query
import com.uznewmax.clients.api.entities.ClientEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ClientsDao {


    @Query("select *from clients")
    fun getAllClients(): Flow<List<ClientEntity>>

}