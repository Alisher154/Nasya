package uz.texnopos.nasya.presentation.main.products.viewmodel

import androidx.lifecycle.LiveData
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.utils.State

interface ProductsVM {
    val categories: LiveData<State<List<Category>>>
    val products: LiveData<State<List<Product>>>
    fun getAllCategories()
    fun getProductsByCategoryId(categoryId: Int)
}