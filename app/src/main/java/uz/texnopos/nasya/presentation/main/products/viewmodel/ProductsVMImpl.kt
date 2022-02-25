package uz.texnopos.nasya.presentation.main.products.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.texnopos.nasya.presentation.main.products.usecase.ProductsFragmentUC
import javax.inject.Inject

@HiltViewModel
class ProductsVMImpl @Inject constructor(private val useCase: ProductsFragmentUC) : ViewModel(),
    ProductsVM {


}