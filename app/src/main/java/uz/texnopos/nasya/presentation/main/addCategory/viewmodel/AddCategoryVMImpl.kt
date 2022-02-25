package uz.texnopos.nasya.presentation.main.addCategory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import uz.texnopos.nasya.data.local.room.entities.Category
import javax.inject.Inject

@HiltViewModel
class AddCategoryVMImpl @Inject constructor(private val useCase: AddCategoryVM) : ViewModel(),
    AddCategoryVM {
    override fun addCategory(category: Category) {
        viewModelScope.launch {
            useCase.addCategory(category)
        }
    }

}