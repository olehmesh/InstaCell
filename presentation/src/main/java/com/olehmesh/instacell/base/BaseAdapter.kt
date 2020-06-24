package com.olehmesh.instacell.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    private var array = mutableListOf<T>()

    override fun getItemCount(): Int = this.array.size

    fun setData(items: List<T>) {
        this.array.addAll(items)
    }

    fun getItem(i: Int): T = this.array[i]

    fun getItems(): List<T> = this.array

}