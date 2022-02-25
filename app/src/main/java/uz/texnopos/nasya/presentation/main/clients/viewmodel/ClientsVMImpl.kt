package uz.texnopos.nasya.presentation.main.clients.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.presentation.main.clients.usecase.ClientsFragmentUC
import uz.texnopos.nasya.utils.State
import uz.texnopos.nasya.utils.showLogD
import javax.inject.Inject

@HiltViewModel
class ClientsVMImpl @Inject constructor(private val useCase: ClientsFragmentUC) : ViewModel(),
    ClientsVM {
    override val clients = MutableLiveData<State<List<Client>>>()
    override fun getAllClients() {
        clients.value = State.LoadingState
        useCase.getAllClients().onEach {
            showLogD("VM: $it")
            clients.value = State.SuccessState(it)
        }.launchIn(viewModelScope)
    }
}