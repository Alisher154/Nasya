package com.uznewmax.home.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.shape.CornerFamily
import com.google.android.material.shape.MaterialShapeDrawable
import com.uznewmax.home.R
import com.uznewmax.home.databinding.FragmentHomeBinding


class HomeFragment : Fragment(R.layout.fragment_home) {

    private val binding by viewBinding(FragmentHomeBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAppBarCornersRadius()
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