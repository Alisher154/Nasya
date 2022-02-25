package uz.texnopos.nasya.presentation.main.addProduct.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.texnopos.nasya.presentation.main.addProduct.viewmodel.AddCategoryVM
import javax.inject.Inject

@HiltViewModel
class AddProductVMImpl @Inject constructor(private val useCase: AddCategoryVM) : ViewModel(),
    AddCategoryVM {

}