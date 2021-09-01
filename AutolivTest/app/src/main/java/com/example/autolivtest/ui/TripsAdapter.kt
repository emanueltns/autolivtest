package com.example.autolivtest.ui

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.autolivtest.R
import com.example.autolivtest.databinding.ListItemBinding
import com.example.autolivtest.services.model.Trip
import com.example.autolivtest.util.inflate

class TripsAdapter(private var items: List<Trip>,
                   private var itemListener: ItemListener) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item), itemListener)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateData(items : List<Trip>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class ViewHolder(private val itemView: View, private val clickListener : ItemListener) : RecyclerView.ViewHolder(itemView) {

    fun bind(selectedTrip : Trip) {
        itemView.setOnClickListener{clickListener.invoke(selectedTrip)}
    }
}