package uz.texnopos.nasya.presentation.main.addclient.viewmodel

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.utils.State

interface AddClientVM {
    val register: LiveData<State<String>>
    fun clientRegister(client: Client)
}