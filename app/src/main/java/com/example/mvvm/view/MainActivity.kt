package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.model.Mahasiswa
import com.example.mvvm.R
import com.example.mvvm.adapter.ListPlaceAdapter
import com.example.mvvm.viewModel.MainViewModel
import com.example.mvvm.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ListPlaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.main = viewModel

        setupRecyclerView()
        observeLiveData()
        viewModel.getListPlace()
    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerViewPlace.layoutManager = layoutManager

        adapter = ListPlaceAdapter(this)
        binding.recyclerViewPlace.adapter = adapter
    }

    private fun observeLiveData() {
        viewModel.listPlace.observe(this, Observer {
            adapter.setData(it?.data!!)
            adapter.notifyDataSetChanged()
        })
        viewModel.error.observe(this, Observer {
            Toasty.error(this, "Error ambil Data", Toast.LENGTH_SHORT).show()
        })
    }
}
