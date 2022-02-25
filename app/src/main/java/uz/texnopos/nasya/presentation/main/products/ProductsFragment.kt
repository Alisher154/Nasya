package uz.texnopos.nasya.presentation.main.products

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.FragmentProductsBinding
import uz.texnopos.nasya.presentation.main.products.adapters.CategoryAdapter
import uz.texnopos.nasya.presentation.main.products.adapters.ProductsAdapter
import uz.texnopos.nasya.presentation.main.products.viewmodel.ProductsVMImpl
import uz.texnopos.nasya.utils.State

@AndroidEntryPoint
class ProductsFragment : Fragment(R.layout.fragment_products) {
    private val binding by viewBinding(FragmentProductsBinding::bind)
    private val categoryAdapter = CategoryAdapter()
    private val productsAdapter = ProductsAdapter()
    private val viewModel by viewModels<ProductsVMImpl>()
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getAllCategories()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        navController = Navigation.findNavController(requireActivity(), R.id.fcvMain)
        binding.apply {
            rvCategory.adapter = categoryAdapter
            rvProducts.adapter = productsAdapter
            categoryAdapter.onItemClick { categoryId ->
                if (categoryId == -1) {
                    navController.navigate(R.id.action_mainFragment_to_addCategoryFragment)
                } else {
                    viewModel.getProductsByCategoryId(categoryId)
                }
            }
        }
    }

    private fun observe() {
        viewModel.categories.observe(requireActivity()) {
            if (it is State.SuccessState) {
                categoryAdapter.setData(it.data)
            }
        }
        viewModel.products.observe(viewLifecycleOwner) {
            if (it is State.SuccessState) {
                productsAdapter.setData(it.data)
            }
        }
    }
}