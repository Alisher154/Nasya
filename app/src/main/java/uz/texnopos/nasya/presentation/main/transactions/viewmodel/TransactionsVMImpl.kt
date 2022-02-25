package uz.texnopos.nasya.presentation.main.transactions.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.texnopos.nasya.presentation.main.transactions.usecase.TransactionsFragmentUC
import javax.inject.Inject

@HiltViewModel
class TransactionsVMImpl @Inject constructor(private val useCase: TransactionsFragmentUC) :
    ViewModel(),
    TransactionsVM {


}