package com.example.cft.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.cft.databinding.ItemBinBinding
import com.example.cft.domain.models.Bin

class BinAdapter(

) : ListAdapter<Bin, BinAdapter.BinHolder>(BinCallBack){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BinHolder {
        val binding = ItemBinBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BinHolder(binding)
    }

    override fun onBindViewHolder(holder: BinHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class BinHolder(private val viewBinding: ItemBinBinding):
            RecyclerView.ViewHolder(viewBinding.root){
                fun bind(bin: Bin){
                    viewBinding.binSaved.text = bin.valueBin
                }
            }
}

object BinCallBack: DiffUtil.ItemCallback<Bin>(){
    override fun areItemsTheSame(oldItem: Bin, newItem: Bin): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Bin, newItem: Bin): Boolean {
        return oldItem == newItem
    }
}