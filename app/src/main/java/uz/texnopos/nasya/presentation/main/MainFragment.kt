package uz.texnopos.nasya.presentation.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import uz.texnopos.nasya.R
import uz.texnopos.nasya.databinding.BottomSheetBinding
import uz.texnopos.nasya.databinding.FragmentMainBinding
import uz.texnopos.nasya.utils.onClick

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding by viewBinding(FragmentMainBinding::bind)


    private lateinit var childNavController: NavController
    lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        childNavController = Navigation.findNavController(requireActivity(), R.id.fcvMainFragment)
        navController = Navigation.findNavController(view)

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val dialogBinding =
            BottomSheetBinding.bind(layoutInflater.inflate(R.layout.bottom_sheet, null))
        bottomSheetDialog.setContentView(dialogBinding.root)
        dialogBinding.apply {
            tvAddNewClient.onClick {
                navController.navigate(R.id.action_mainFragment_to_addClientFragment)
                bottomSheetDialog.dismiss()
            }
            tvAddNewProduct.onClick {
                navController.navigate(R.id.action_mainFragment_to_addProductFragment)
                bottomSheetDialog.dismiss()
            }
        }

        setAppBarCornersRadius()
        binding.apply {
            bottomNav.setupWithNavController(childNavController)
            bottomNav.background = null
            addFab.onClick {
                when (childNavController.currentDestination?.id) {
                    R.id.clientsFragment -> {
                        navController.navigate(R.id.action_mainFragment_to_addClientFragment)
                    }
                    R.id.productFragment -> {
                        navController.navigate(R.id.action_mainFragment_to_addProductFragment)
                    }
                    else -> {
                        bottomSheetDialog.show()
                    }
                }
            }
        }
    }

    private fun setAppBarCornersRadius() {
        val radius = resources.getDimension(R.dimen.margin_standard)
        val bottomBarBackground = binding.babMain.background as MaterialShapeDrawable
        bottomBarBackground.shapeAppearanceModel =
            bottomBarBackground.shapeAppearanceModel
                .toBuilder()
                .setTopRightCorner(CornerFamily.ROUNDED, radius)
                .setTopLeftCorner(CornerFamily.ROUNDED, radius)
                .build()
    }

}