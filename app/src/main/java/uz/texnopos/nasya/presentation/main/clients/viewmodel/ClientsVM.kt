package uz.texnopos.nasya.presentation.main.clients.viewmodel

import androidx.lifecycle.LiveData
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.utils.State

interface ClientsVM {
    val clients:LiveData<State<List<Client>>>
    fun getAllClients()
}