package com.olehmesh.instacell.base

import androidx.recyclerview.widget.DiffUtil

open class BaseDiffUtil<T>(private val oldItem: List<T>, private val newItem: List<T>) :
    DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItem[oldItemPosition] == newItem[newItemPosition]
    }

    override fun getOldListSize() = oldItem.size

    override fun getNewListSize() = newItem.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldItem[oldItemPosition] == newItem[newItemPosition]
    }

}