package uz.texnopos.nasya.presentation.main.payment.usecase

import uz.texnopos.nasya.domain.repository.ClientRepository
import javax.inject.Inject

class PaymentFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    PaymentFragmentUC {

}