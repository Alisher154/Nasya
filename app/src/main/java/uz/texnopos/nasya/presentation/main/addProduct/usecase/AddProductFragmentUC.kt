package uz.texnopos.nasya.presentation.main.addProduct.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product

interface AddProductFragmentUC {
    suspend fun addProduct(product: Product)
    fun getAllCategories(): Flow<List<Category>>
}