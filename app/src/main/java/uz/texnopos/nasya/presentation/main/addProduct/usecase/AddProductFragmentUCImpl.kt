package uz.texnopos.nasya.presentation.main.addProduct.usecase

import kotlinx.coroutines.flow.Flow
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.repository.interfaces.ProductRepository
import javax.inject.Inject

class AddProductFragmentUCImpl @Inject constructor(private val repo: ProductRepository) :
    AddProductFragmentUC {
    override suspend fun addProduct(product: Product) {
        repo.addProduct(product)
    }

    override fun getAllCategories(): Flow<List<Category>> {
        return repo.getAllCategories()
    }

}