package com.example.fullTransactionFragments.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fullTransactionFragments.R
import com.example.fullTransactionFragments.databinding.ActivityMainBinding
import com.example.fullTransactionFragments.model.Name
import com.example.fullTransactionFragments.ui.fragments.FirstFragment
import com.example.fullTransactionFragments.ui.fragments.SecondFragment

class MainActivity : AppCompatActivity(), FirstFragment.OnItemFragmentListener {

  lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)
  }

  override fun setOnItemClick(name: Name) {
    val secondFrag = SecondFragment.getInstance(name)
    supportFragmentManager.beginTransaction().replace(R.id.sContainer, secondFrag).commit()
  }
}