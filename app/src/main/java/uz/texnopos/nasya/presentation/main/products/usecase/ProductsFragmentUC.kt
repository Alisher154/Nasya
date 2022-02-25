package uz.texnopos.nasya.presentation.main.products.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product

interface ProductsFragmentUC {
    fun getAllCategories(): Flow<List<Category>>
    fun getProductsByCategoryId(categoryId: Int):Flow<List<Product>>
}