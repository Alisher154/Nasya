package uz.texnopos.nasya.presentation.main.payment

import android.view.View
import uz.texnopos.nasya.databinding.FragmentPaymentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.texnopos.nasya.presentation.main.transactions.TransactionsFragment

class PaymentDialog(private val mFragment: TransactionsFragment) : BottomSheetDialogFragment() {
    private var savedViewInstance: View? = null
    lateinit var bind: FragmentPaymentBinding

}