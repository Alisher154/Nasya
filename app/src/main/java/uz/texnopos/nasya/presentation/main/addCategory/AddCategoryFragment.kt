package uz.texnopos.nasya.presentation.main.addCategory

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.databinding.FragmentAddCategoryBinding
import uz.texnopos.nasya.presentation.main.addCategory.viewmodel.AddCategoryVMImpl
import uz.texnopos.nasya.utils.onClick
import uz.texnopos.nasya.utils.textToString

@AndroidEntryPoint
class AddCategoryFragment : Fragment(R.layout.fragment_add_category) {
    private val binding by viewBinding(FragmentAddCategoryBinding::bind)
    private val viewModel by viewModels<AddCategoryVMImpl>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnAddCategory.onClick {
                val category = Category(categoryName = etCategoryName.textToString())
                viewModel.addCategory(category)
                requireActivity().onBackPressed()
            }
        }
    }

}