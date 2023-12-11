package com.shamardn.reverserecyclerviewinkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.shamardn.reverserecyclerviewinkotlin.databinding.ListItemBinding

class MainAdapter(private var items: List<String>): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val currentItem = items[items.size - 1 - position]
        holder.binding.itemTv.text = currentItem
    }

    override fun getItemCount() = items.size

    class MainViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ListItemBinding.bind(itemView)
    }

}