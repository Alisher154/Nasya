package uz.texnopos.nasya.presentation.main.addProduct.usecase

import uz.texnopos.nasya.repository.interfaces.ClientRepository
import javax.inject.Inject

class AddProductFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    AddProductFragmentUC {

}