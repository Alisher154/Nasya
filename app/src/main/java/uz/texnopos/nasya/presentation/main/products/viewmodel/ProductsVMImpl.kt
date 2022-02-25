package uz.texnopos.nasya.presentation.main.products.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.presentation.main.products.usecase.ProductsFragmentUC
import uz.texnopos.nasya.utils.State
import javax.inject.Inject

@HiltViewModel
class ProductsVMImpl @Inject constructor(private val useCase: ProductsFragmentUC) : ViewModel(),
    ProductsVM {
    override val categories = MutableLiveData<State<List<Category>>>()
    override val products = MutableLiveData<State<List<Product>>>()

    override fun getAllCategories() {
        categories.value = State.LoadingState
        useCase.getAllCategories().onEach {
            categories.value = State.SuccessState(it)
        }.launchIn(viewModelScope)
    }

    override fun getProductsByCategoryId(categoryId: Int) {
        products.value = State.LoadingState
        useCase.getProductsByCategoryId(categoryId).onEach {
            products.value = State.SuccessState(it)
        }.launchIn(viewModelScope)
    }
}
