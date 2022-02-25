package uz.texnopos.nasya.presentation.main.products.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.databinding.ItemCategoryBinding
import uz.texnopos.nasya.utils.inflate
import uz.texnopos.nasya.utils.onClick

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(category: Category) {
            binding.apply {
                tvCategoryName.text = category.categoryName
                tvCategoryName.onClick {
                    onCategoryItemClick.invoke(category.id ?: -1)
                }
            }
        }
    }

    var models: MutableList<Category> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(ItemCategoryBinding.bind(parent.inflate(R.layout.item_category)))
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    private var onCategoryItemClick: (id: Int) -> Unit = { }
    fun setOnCategoryItemClickListener(onCategoryItemClick: (id: Int) -> Unit) {
        this.onCategoryItemClick = onCategoryItemClick
    }

    override fun getItemCount(): Int = models.size
}