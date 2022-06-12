package com.uznewmax.clients.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uznewmax.clients.models.Client
import com.uznewmax.clients.usecase.ClientsUC
import com.uznewmax.core.utils.State
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ClientsVMImpl @Inject constructor(private val useCase: ClientsUC) : ViewModel(),
    ClientsVM {
    override val clients = MutableLiveData<State<List<Client>>>()
    override fun getAllClients() {
        clients.value = State.LoadingState
        useCase.invoke().onEach {
            clients.value = State.SuccessState(it)
        }.launchIn(viewModelScope)
    }
}