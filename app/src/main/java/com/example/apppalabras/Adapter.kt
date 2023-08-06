package com.example.apppalabras

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PalabraAdapter(private val listaPalabras: MutableList<String>, private val onItemClick: (Int) -> Unit) :
    RecyclerView.Adapter<PalabraAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val palabraTextView: TextView = itemView.findViewById(R.id.textViewPalabra)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val palabra = listaPalabras[position]
        holder.palabraTextView.text = palabra

        holder.itemView.setOnClickListener {
            listaPalabras.add(0, "Clicked $palabra")
            notifyDataSetChanged()
        }
    }

    override fun getItemCount() = listaPalabras.size
}
