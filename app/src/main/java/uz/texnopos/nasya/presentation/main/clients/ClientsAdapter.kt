package uz.texnopos.nasya.presentation.main.clients

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.texnopos.nasya.R
import uz.texnopos.nasya.data.local.room.entities.Client
import uz.texnopos.nasya.databinding.ItemClientBinding
import uz.texnopos.nasya.utils.onClick

class ClientsAdapter : RecyclerView.Adapter<ClientsAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemClientBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun populateModel(client: Client) {
            binding.apply {
                tvClientId.text = root.context.getString(R.string.client_id, client.id)
                tvClientFullName.text = client.fullName
                tvProductName.text = client.documentNumber
                cardView.onClick {
                    onItemClick(client)
                }
            }
        }
    }

    private var models: MutableList<Client> = mutableListOf()
    fun setData(models: List<Client>) {
        this.models.clear()
        for (i in models.indices) {
            if (!this.models.contains(models[i])) {
                this.models.add(models[i])
                notifyItemChanged(i)
            }
        }
    }

    private var onItemClick: (singleClient: Client) -> Unit = {}

    fun onItemClick(onItemClick: (singleClient: Client) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun getItemCount() = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemClientBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

}