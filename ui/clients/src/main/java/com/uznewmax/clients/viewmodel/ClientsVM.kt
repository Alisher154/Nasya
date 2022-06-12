package com.uznewmax.clients.viewmodel

import androidx.lifecycle.LiveData
import com.uznewmax.clients.models.Client
import com.uznewmax.core.utils.State

interface ClientsVM {
    val clients: LiveData<State<List<Client>>>
    fun getAllClients()
}