package com.example.recycleviewlearn

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewlearn.databinding.ItemDisasterBinding

typealias onClickDisaster = (Beach) -> Unit

class BeachAdapter(private val listDisaster: List<Beach>,
                   private val onClickDisaster: onClickDisaster) :
    RecyclerView.Adapter<BeachAdapter.ItemDisasterViewHolder>(){
    inner class ItemDisasterViewHolder(private val binding :
    ItemDisasterBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind (data:Beach){
            with(binding){
                gambarPantai.setImageResource(data.image)
                txtBeachName.text = data.nameBeach
                txtDateType.text = data.typeDate
                itemView.setOnClickListener{
                    onClickDisaster(data)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int = listDisaster.size

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }
}