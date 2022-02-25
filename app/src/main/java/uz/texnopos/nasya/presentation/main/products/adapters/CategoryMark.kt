package uz.texnopos.nasya.presentation.main.products.adapters

import uz.texnopos.nasya.data.local.room.entities.Category

data class CategoryMark(
    val category: Category,
    var isMarked: Boolean = false
)