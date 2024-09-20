package com.alvarado.tribaljob.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alvarado.tribaljob.databinding.ItemCategoriesBinding

class CategoriesAdapter(
    val data: List<String>
): RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val viewBinding = ItemCategoriesBinding.inflate(LayoutInflater.from(parent.context))
        return CategoriesViewHolder(viewBinding)
    }

    override fun getItemCount(): Int {
        return data.count()
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.binding.apply {
            categoryName.text = data.get(position)
        }
    }
}

class CategoriesViewHolder(val binding: ItemCategoriesBinding): RecyclerView.ViewHolder(binding.root)