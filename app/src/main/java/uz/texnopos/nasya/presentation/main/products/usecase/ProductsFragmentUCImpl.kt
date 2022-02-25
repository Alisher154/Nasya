package uz.texnopos.nasya.presentation.main.products.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.repository.interfaces.ProductRepository
import javax.inject.Inject

class ProductsFragmentUCImpl @Inject constructor(private val repo: ProductRepository) :
    ProductsFragmentUC {
    override fun getAllCategories(): Flow<List<Category>> {

        return repo.getAllCategories().map {
            val categories = mutableListOf(Category(-1, "Add"))
            categories.addAll(it)
            categories
        }

    }

    override fun getProductsByCategoryId(categoryId: Int): Flow<List<Product>> {
        return repo.getProductsByCategoryId(categoryId)
    }

}