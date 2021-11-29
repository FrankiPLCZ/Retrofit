package com.example.retrofit2

import Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class RVAdapter(val data:List<Data>):RecyclerView.Adapter<RVAdapter.RVViewHolder>() {
    inner class RVViewHolder(itemView :View):RecyclerView.ViewHolder(itemView){
        val img =itemView.findViewById<ImageView>(R.id.img)
        val id1 = itemView.findViewById<TextView>(R.id.id1)
        val id2 = itemView.findViewById<TextView>(R.id.id2)
        val first_name = itemView.findViewById<TextView>(R.id.first_name)
        val last_name = itemView.findViewById<TextView>(R.id.last_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemlayout,parent,false)
        return RVViewHolder(view)
    }

    override fun onBindViewHolder(holder: RVViewHolder, position: Int) {
        Picasso.get().load(data[position].avatar).into(holder.img)
        holder.id1.text = data[position].id.toString()
        holder.id2.text = data[position].email
        holder.first_name.text = data[position].first_name
        holder.last_name.text = data[position].last_name


    }

    override fun getItemCount(): Int {
        return data.size
    }
}