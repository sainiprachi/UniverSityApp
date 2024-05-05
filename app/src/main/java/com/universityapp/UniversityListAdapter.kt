package com.universityapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.universityapp.databinding.UniversityListBinding
import com.universityapp.model.University

class UniversityListAdapter (private val universityList : List<University> ,private  val onClickListener: OnClickListener) : RecyclerView.Adapter<UniversityListAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding : UniversityListBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =  UniversityListBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, @SuppressLint("RecyclerView") position: Int) {
        with(holder){
            with(universityList[position]){
                binding.tvUniversityName.text  = this.name.trim()
                binding.tvUniversityState.text = this.country?.trim()
                holder.itemView.setOnClickListener { onClickListener.onClick(universityList[position]) }

            }
        }

    }


    override fun getItemCount(): Int {
        return universityList.size
    }

    class OnClickListener(val clickListener: (university: University) -> Unit) {
        fun onClick(university: University) = clickListener(university)
    }
}