package com.uznewmax.clients.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.uznewmax.clients.models.Client
import com.uznewmax.clients.ui.databinding.ItemClientBinding
import com.uznewmax.core.utils.onClick

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