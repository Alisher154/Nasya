package uz.texnopos.nasya.presentation.main.transactions.usecase

import uz.texnopos.nasya.repository.interfaces.ClientRepository
import javax.inject.Inject

class TransactionsFragmentUCImpl @Inject constructor(private val repo: ClientRepository) :
    TransactionsFragmentUC {

}