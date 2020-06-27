package com.olehmesh.instacell.base

import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<T, VH : RecyclerView.ViewHolder> : RecyclerView.Adapter<VH>() {

    private var itemList = mutableListOf<T>()

    fun setData(items: List<T>) {
        itemList.clear()
        itemList.addAll(items)
    }

    override fun getItemCount(): Int = itemList.size

    fun getItem(i: Int): T = itemList[i]

    fun getItemList(): List<T> = itemList


}