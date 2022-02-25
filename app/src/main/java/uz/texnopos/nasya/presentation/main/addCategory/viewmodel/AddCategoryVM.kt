package uz.texnopos.nasya.presentation.main.addCategory.viewmodel

import uz.texnopos.nasya.data.local.room.entities.Category

interface AddCategoryVM {
    fun addCategory(category: Category)
}