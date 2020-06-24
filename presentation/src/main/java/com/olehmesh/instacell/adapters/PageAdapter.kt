package com.olehmesh.instacell.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.olehmesh.instacell.base.BaseAdapter
import com.olehmesh.instacell.databinding.ViewPagerItemBinding

class PageAdapter:
    BaseAdapter<String, PageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ViewPagerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ViewPagerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: String) {
            binding.imageAsset = item
        }
    }
}