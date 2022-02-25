package uz.texnopos.nasya.presentation.main.addCategory.usecase

import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.repository.interfaces.ProductRepository
import javax.inject.Inject

class AddCategoryFragmentUCImpl @Inject constructor(private val repo: ProductRepository) :
    AddCategoryFragmentUC {
    override suspend fun addCategory(category: Category) {
        repo.addCategory(category)
    }

}