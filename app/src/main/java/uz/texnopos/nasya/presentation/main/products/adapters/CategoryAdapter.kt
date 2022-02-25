package uz.texnopos.nasya.presentation.main.products.adapters

import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.databinding.ItemCategoryBinding
import uz.texnopos.nasya.utils.inflate
import uz.texnopos.nasya.utils.onClick

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    private var lastMarkedCardView: MaterialCardView? = null
    private var lastMarkedTextView: MaterialTextView? = null

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(categoryMark: CategoryMark, position: Int) {
            binding.apply {
                tvCategoryName.text = categoryMark.category.categoryName
                clMain.onClick {
                    if (categoryMark.category.id != -1) {
                        changeCardBackground()
                        tvCategoryName.changeTextColor()
                    }
                    onCategoryItemClick.invoke(categoryMark.category.id ?: -1)
                }
            }
        }

        private fun MaterialCardView.changeCardBackground() {
            this.setColor(R.color.dark_blue)
            lastMarkedCardView?.setColor(R.color.white)
            lastMarkedCardView = this
        }

        fun MaterialTextView.changeTextColor() {
            this.setTextColor2(R.color.white)
            lastMarkedTextView?.setTextColor2(R.color.black)
            lastMarkedTextView = this
        }

        private fun MaterialTextView.setTextColor2(colorId: Int) {
            this.setTextColor(ContextCompat.getColor(this.context, colorId))
        }

        private fun MaterialCardView.setColor(colorId: Int) {
            this.setCardBackgroundColor(ContextCompat.getColor(this.context, colorId))
        }
    }

    private var models: MutableList<CategoryMark> = mutableListOf()

    fun setData(models: List<Category>) {
        notifyItemRangeRemoved(0, this.models.size)
        this.models.clear()
        for (i in models.indices) {
            this.models.add(CategoryMark(models[i]))
            notifyItemInserted(i)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.bind(parent.inflate(R.layout.item_category)))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

    private var onCategoryItemClick: (id: Int) -> Unit = { }
    fun onItemClick(onCategoryItemClick: (id: Int) -> Unit) {
        this.onCategoryItemClick = onCategoryItemClick
    }

    override fun getItemCount(): Int = models.size
}