package uz.texnopos.nasya.presentation.main.products.usecase

import uz.texnopos.nasya.repository.interfaces.ProductRepository
import javax.inject.Inject

class ProductsFragmentUCImpl @Inject constructor(private val repo: ProductRepository) :
    ProductsFragmentUC {

}