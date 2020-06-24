package com.olehmesh.instacell.fragments.fragment_main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.olehmesh.instacell.R
import com.olehmesh.instacell.adapters.MainAdapter
import com.olehmesh.instacell.base.BaseDiffUtil
import com.olehmesh.instacell.base.BaseFragment
import com.olehmesh.repository.InstCellModel
import kotlinx.android.synthetic.main.fragment_main.*

class FragmentMain : BaseFragment() {

    override val layoutResId: Int
        get() = R.layout.fragment_main

    private val mainViewModel by viewModels<com.olehmesh.domain.MainViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mainViewModel.getData().observe(viewLifecycleOwner, Observer { initRecyclerView(it) })

    }

    private fun initRecyclerView(items: List<InstCellModel>) {

        val adapter = MainAdapter()
        val diffUtil = BaseDiffUtil(adapter.getItems(), items)
        val resultCalc = DiffUtil.calculateDiff(diffUtil)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
        adapter.setData(items)
        resultCalc.dispatchUpdatesTo(adapter)
        recyclerView.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

    }

}