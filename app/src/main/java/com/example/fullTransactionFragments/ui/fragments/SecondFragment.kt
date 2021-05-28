package com.example.fullTransactionFragments.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fullTransactionFragments.databinding.FragmentSecondBinding
import com.example.fullTransactionFragments.model.Name

class SecondFragment : Fragment() {

  private lateinit var binding: FragmentSecondBinding
  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    // Inflate the layout for this fragment
    binding = FragmentSecondBinding.inflate(inflater, container, false)
    val name: Name = arguments?.get("name") as Name
    with(binding) {
      tvId.text = name.id.toString()
      tvName.text = name.name
    }

    return binding.root
  }

  companion object {

    fun getInstance(name: Name): SecondFragment {
      val bundle = Bundle()
      bundle.putParcelable("name", name)
      val secondFrag = SecondFragment()
      secondFrag.arguments = bundle
      return secondFrag
    }
  }
}