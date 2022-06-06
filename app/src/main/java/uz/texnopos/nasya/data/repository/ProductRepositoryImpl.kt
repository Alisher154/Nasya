package uz.texnopos.nasya.data.repository

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import uz.texnopos.nasya.data.local.room.NasyaDao
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(private val dao: NasyaDao) : ProductRepository {
    override suspend fun addProduct(product: Product) {
        withContext(IO) { dao.addProduct(product) }
    }

    override fun getProductsByCategoryId(categoryId: Int): Flow<List<Product>> {
        return dao.getProductsByCategoryId(categoryId)
    }

    override suspend fun deleteProductById(productId: Int) {
        withContext(IO) { dao.deleteProductById(productId) }
    }

    override suspend fun addCategory(category: Category) {
        withContext(IO) { dao.addCategory(category) }
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return dao.getAllCategories()
    }

    override suspend fun deleteCategoryById(categoryId: Int) {
        withContext(IO) { dao.deleteCategoryById(categoryId) }
    }

}