package com.example.fullTransactionFragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fullTransactionFragments.databinding.ItemRecyclerBinding
import com.example.fullTransactionFragments.interfaces.OnItemRecycleClick
import com.example.fullTransactionFragments.model.Name

/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 27/05/2021
 */
class NameAdapter : RecyclerView.Adapter<NameAdapter.NameViewHolder>() {

  private var list = mutableListOf<Name>()
  private lateinit var listener: OnItemRecycleClick

  fun setList(_list: MutableList<Name>) {
    list = _list
  }

  fun setListener(_listener: OnItemRecycleClick) {
    listener = _listener
  }

  class NameViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
    return NameViewHolder(ItemRecyclerBinding.inflate(LayoutInflater.from(parent.context), parent, false))
  }

  override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
    with(holder.binding) {
      tvId.text = list[position].id.toString()
      tvName.text = list[position].name

      root.setOnClickListener {
        listener.setOnItemRecycle(list[position])
      }
    }
  }

  override fun getItemCount() = list.size
}