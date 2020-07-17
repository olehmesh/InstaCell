package com.olehmesh.instacell.extensions

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.itemDecorate() {
    addItemDecoration(
        DividerItemDecoration(
            this.context,
            DividerItemDecoration.VERTICAL
        )
    )
}