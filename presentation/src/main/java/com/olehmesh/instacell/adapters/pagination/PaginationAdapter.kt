package com.olehmesh.instacell.adapters.pagination

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.olehmesh.instacell.R
import com.olehmesh.instacell.adapters.view_pager.ViewPagerTransformer
import com.olehmesh.instacell.adapters.view_pager.ViewPagerAdapter
import com.olehmesh.instacell.databinding.ListItemBinding
import com.olehmesh.instacell.extensions.toast
import com.olehmesh.repository.models.InstCellModel
import kotlinx.android.synthetic.main.list_item.view.*

class PaginationAdapter :
    PagedListAdapter<InstCellModel, PaginationAdapter.ViewHolder>(
        DiffUtilCallBack()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }

        val context = holder.itemView.context

        holder.itemView.imgFavorite.setOnClickListener { context.toast(context.getString(R.string.click_to_favorite) + "[" + position + "]") }
        holder.itemView.imgComment.setOnClickListener { context.toast(context.getString(R.string.click_to_comment) + "[" + position + "]") }
        holder.itemView.imgSend.setOnClickListener { context.toast(context.getString(R.string.click_to_send) + "[" + position + "]") }
        holder.itemView.imgBookmark.setOnClickListener { context.toast(context.getString(R.string.click_to_bookmark) + "[" + position + "]") }
    }

    class ViewHolder(private val binding: ListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private val pageAdapter by lazy { ViewPagerAdapter() }


        fun bind(item: InstCellModel) {

            binding.model = item
            binding.viewPager2.adapter = pageAdapter

            binding.viewPager2.setPageTransformer(ViewPagerTransformer())
            binding.viewPager2.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)

                    binding.pageIndicator.count = pageAdapter.itemCount
                    binding.pageIndicator.selection = position

                }

            })

            pageAdapter.setData(item.images!!)
            binding.pageIndicator.count = pageAdapter.itemCount
            binding.executePendingBindings()
        }
    }


    class DiffUtilCallBack : DiffUtil.ItemCallback<InstCellModel>() {
        override fun areItemsTheSame(oldItem: InstCellModel, newItem: InstCellModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: InstCellModel, newItem: InstCellModel): Boolean {
            return oldItem == newItem
        }
    }

}