package uz.texnopos.nasya.presentation.main.addProduct.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.presentation.main.addProduct.usecase.AddProductFragmentUC
import javax.inject.Inject

@HiltViewModel
class AddProductVMImpl @Inject constructor(private val useCase: AddProductFragmentUC) : ViewModel(),
    AddProductVM {
    override val categories = MutableLiveData<List<Category>>()

    override fun addProduct(product: Product) {
        viewModelScope.launch {
            useCase.addProduct(product)
        }
    }

    override fun getAllCategories() {
        useCase.getAllCategories().onEach {
            categories.value = it
        }.launchIn(viewModelScope)
    }

}