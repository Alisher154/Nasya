package uz.texnopos.nasya.repository.interfaces

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product

interface ProductRepository {

    suspend fun addProduct(product: Product)

    fun getProductsByCategoryId(categoryId: Int): Flow<List<Product>>

    suspend fun deleteProductById(productId: Int)

    suspend fun addCategory(category: Category)

    fun getAllCategories(): Flow<List<Category>>

    suspend fun deleteCategoryById(categoryId: Int)
}