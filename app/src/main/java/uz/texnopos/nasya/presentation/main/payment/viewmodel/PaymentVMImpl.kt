package uz.texnopos.nasya.presentation.main.payment.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.texnopos.nasya.presentation.main.payment.usecase.PaymentFragmentUC
import javax.inject.Inject

@HiltViewModel
class PaymentVMImpl @Inject constructor(private val useCase: PaymentFragmentUC) : ViewModel(),
    PaymentVM {


}