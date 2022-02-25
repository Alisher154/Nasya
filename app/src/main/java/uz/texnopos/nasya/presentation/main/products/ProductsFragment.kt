package uz.texnopos.nasya.presentation.main.products

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentProductsBinding
import uz.texnopos.nasya.presentation.main.products.adapters.CategoryAdapter
import uz.texnopos.nasya.presentation.main.products.adapters.ProductsAdapter

class ProductsFragment : Fragment(R.layout.fragment_products) {
    private val binding by viewBinding(FragmentProductsBinding::bind)
    private val categoryAdapter = CategoryAdapter()
    private val productsAdapter = ProductsAdapter()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            rvCategory.adapter = categoryAdapter
            rvProducts.adapter = productsAdapter
        }
    }
}