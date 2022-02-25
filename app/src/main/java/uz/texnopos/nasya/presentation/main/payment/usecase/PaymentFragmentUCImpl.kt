package uz.texnopos.nasya.presentation.main.payment.usecase

import uz.texnopos.nasya.presentation.main.products.usecase.ProductsFragmentUC
import uz.texnopos.nasya.repository.interfaces.ClientRepository
import javax.inject.Inject

class PaymentFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    PaymentFragmentUC {

}