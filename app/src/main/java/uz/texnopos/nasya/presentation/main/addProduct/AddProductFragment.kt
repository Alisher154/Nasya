package uz.texnopos.nasya.presentation.main.addProduct

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.databinding.FragmentAddProductBinding
import uz.texnopos.nasya.presentation.main.addProduct.viewmodel.AddProductVMImpl
import uz.texnopos.nasya.utils.*
import uz.texnopos.nasya.utils.mask.MaskWatcherPrice

@AndroidEntryPoint
class AddProductFragment : Fragment(R.layout.fragment_add_product) {
    private val binding by viewBinding(FragmentAddProductBinding::bind)
    private val viewModel by viewModels<AddProductVMImpl>()
    private var categoryId: Int? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getAllCategories()
        binding.apply {
            etPrice.addTextChangedListener(MaskWatcherPrice(etPrice))
            viewModel.categories.observe(viewLifecycleOwner) {
                val categoryAdapter = ArrayAdapter(
                    requireContext(),
                    R.layout.item_drop_down,
                    it.map { category -> category.categoryName })
                selectCategories.setAdapter(categoryAdapter)
                selectCategories.setOnItemClickListener { _, _, position, _ ->
                    categoryId = it[position].id
                }
            }
            btnAddProduct.onClick {
                if (validate()) {
                    val product = Product(
                        categoryId = categoryId!!,
                        productName = etProductName.textToString(),
                        productPrice = etPrice.textToString()
                    )
                    viewModel.addProduct(product)
                    requireActivity().onBackPressed()
                }
            }
        }
    }

    fun FragmentAddProductBinding.validate(): Boolean {
        return when {
            categoryId == null -> {
                toast("Select category")
                false
            }
            etProductName.checkIsEmpty() -> etProductName.showError("Product can't be empty")
            else -> true
        }
    }
}