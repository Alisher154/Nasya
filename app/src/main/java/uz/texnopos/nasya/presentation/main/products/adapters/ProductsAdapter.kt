package uz.texnopos.nasya.presentation.main.products.adapters

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Category
import uz.texnopos.nasya.data.local.room.entities.Product
import uz.texnopos.nasya.databinding.ItemProductBinding
import uz.texnopos.nasya.utils.inflate

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(product: Product) {
            binding.apply {
                tvProductName.text = product.productName

            }
        }
    }

    var models: MutableList<Product> = mutableListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(ItemProductBinding.bind(parent.inflate(R.layout.item_product)))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    private var onCategoryItemClick: (category: Category) -> Unit = { }
    fun setOnProductItemClickListener(onCategoryItemClick: (category: Category) -> Unit) {
        this.onCategoryItemClick = onCategoryItemClick
    }

    override fun getItemCount(): Int = models.size
}