package uz.texnopos.nasya.presentation.main.transactions.usecase

import uz.texnopos.nasya.domain.repository.ClientRepository
import javax.inject.Inject

class TransactionsFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    TransactionsFragmentUC {

}