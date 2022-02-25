package uz.texnopos.nasya.presentation.main.addProduct.viewmodel

import androidx.lifecycle.LiveData
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product

interface AddProductVM {
    val categories: LiveData<List<Category>>
    fun addProduct(product: Product)
    fun getAllCategories()
}