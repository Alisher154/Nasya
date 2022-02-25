package uz.texnopos.nasya.presentation.main.addclient.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.presentation.main.addclient.usecase.AddClientFragmentUC
import uz.texnopos.nasya.utils.State
import javax.inject.Inject

@HiltViewModel
class AddClientVMImpl @Inject constructor(private val useCase: AddClientFragmentUC) : ViewModel(),
    AddClientVM {
    override val register = MutableLiveData<State<String>>()
    override fun clientRegister(client: Client) {

        viewModelScope.launch {
            useCase.clientRegister(client)
        }

    }

}