package com.app.bsc20920

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_single.view.*

class RecyvlerAdapter (private val ent:ArrayList<MainActivity.Bikes>) : RecyclerView.Adapter<RecyvlerAdapter.ViewHolder>() {
    //the class is hodling the list view
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bindItems(bike: MainActivity.Bikes) {
            val textViewName = itemView.name
            val textViewAddress = itemView.address
            val tvStatus = itemView.status
            val tvBikes = itemView.abikes
            textViewName.text = "Name : ${bike.name}"
            textViewAddress.text = "Address : ${bike.address}"
            tvStatus.text = "Status : ${bike.status}"
            tvBikes.text = "Available Bikes : ${bike.availbikes}"
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_single, parent, false)
        return ViewHolder(v)    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(ent[position])
    }

    override fun getItemCount(): Int = ent.size


}
