package com.example.mvvm.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm.R
import com.example.mvvm.databinding.ItemPlaceBinding
import com.example.mvvm.model.ListPlaceResponseModel
import com.example.mvvm.viewModel.ItemPlaceViewModel

class ListPlaceAdapter(val context: Context) :
    RecyclerView.Adapter<ListPlaceAdapter.itemPlaceViewHolder>() {

    private var listPlace: MutableList<ListPlaceResponseModel.PlaceModel> = mutableListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemPlaceViewHolder {
        val binding: ItemPlaceBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item_place,
            parent,
            false
        )
        return itemPlaceViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listPlace.size
    }

    override fun onBindViewHolder(holder: itemPlaceViewHolder, position: Int) {
        holder.bindData(listPlace[holder.adapterPosition])
    }

    fun setData(list: MutableList<ListPlaceResponseModel.PlaceModel>) {
        this.listPlace = list

    }

    class itemPlaceViewHolder(private val binding: ItemPlaceBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(model: ListPlaceResponseModel.PlaceModel) {

            val viewModel = ItemPlaceViewModel(model)
            binding.itemPlace = viewModel

        }
    }


}