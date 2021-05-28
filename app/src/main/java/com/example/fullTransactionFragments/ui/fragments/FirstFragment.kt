package com.example.fullTransactionFragments.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fullTransactionFragments.adapter.NameAdapter
import com.example.fullTransactionFragments.databinding.FragmentFirstBinding
import com.example.fullTransactionFragments.interfaces.OnItemRecycleClick
import com.example.fullTransactionFragments.model.Name
import com.example.fullTransactionFragments.ui.activities.MainActivity

class FirstFragment : Fragment() {

  lateinit var binding: FragmentFirstBinding
  lateinit var listener: OnItemFragmentListener
  private val nameAdapter by lazy { NameAdapter() }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is MainActivity)
      listener = context as OnItemFragmentListener
    else
      throw ClassCastException("you perhaps forget ")
  }
  

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    binding = FragmentFirstBinding.inflate(inflater, container, false)
    with(binding) {
      rvFirst.apply {
        layoutManager = LinearLayoutManager(requireContext())
        setHasFixedSize(true)
        adapter = nameAdapter
      }
      nameAdapter.setList(mutableListOf<Name>().apply {
        add(Name("ahmed", 1))
        add(Name("mohamed", 2))
        add(Name("mahmoud", 3))
        add(Name("hema", 4))
        add(Name("ali", 5))
        add(Name("koko", 6))
      })
      nameAdapter.setListener(object : OnItemRecycleClick {
        override fun setOnItemRecycle(name: Name) {
          listener.setOnItemClick(name)
        }
      })
    }
    return binding.root
  }

  interface OnItemFragmentListener {

    fun setOnItemClick(name: Name)
  }
}