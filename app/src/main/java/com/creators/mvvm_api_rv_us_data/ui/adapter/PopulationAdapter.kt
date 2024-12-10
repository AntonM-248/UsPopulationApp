package com.creators.mvvm_api_rv_us_data.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.creators.mvvm_api_rv_us_data.R
import com.creators.mvvm_api_rv_us_data.data.model.PopulationData

class PopulationAdapter (private var data: List<PopulationData>) :
        RecyclerView.Adapter<PopulationAdapter.PopulationViewHolder>() {
    class PopulationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nationText: TextView = itemView.findViewById(R.id.nationText)
        val populationText: TextView = itemView.findViewById(R.id.populationText)
        val yearText: TextView = itemView.findViewById(R.id.yearText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopulationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.population_data, parent, false)
        return PopulationViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: PopulationViewHolder, position: Int) {
        val item = data[position]
        holder.nationText.text = item.Nation
        holder.populationText.text = item.Population.toString()
        holder.yearText.text = item.Year
    }

    fun updateData(newData: List<PopulationData>) {
        data = newData
        notifyDataSetChanged()
    }
}