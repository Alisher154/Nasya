package uz.texnopos.nasya.presentation.main.addCategory.usecase

import uz.texnopos.nasya.data.local.room.entities.Category

interface AddCategoryFragmentUC {
    suspend fun addCategory(category: Category)
}