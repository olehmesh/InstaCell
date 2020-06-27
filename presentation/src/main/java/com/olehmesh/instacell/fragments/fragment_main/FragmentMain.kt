package com.olehmesh.instacell.fragments.fragment_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.instacell.R
import com.olehmesh.instacell.adapters.pagination.PaginationAdapter
import com.olehmesh.instacell.base.BaseFragment
import com.olehmesh.repository.models.InstCellModel
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_main

    private val mainViewModel by viewModels<com.olehmesh.domain.MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getData().observe(viewLifecycleOwner, Observer { initRecyclerView(it) })

    }

    private fun initRecyclerView(items: PagedList<InstCellModel>) {

        val adapter = PaginationAdapter()
        recyclerView.layoutManager = LinearLayoutManager(context)
        adapter.submitList(items)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                this.context,
                DividerItemDecoration.VERTICAL
            )
        )

    }

}