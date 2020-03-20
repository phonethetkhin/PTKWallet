package com.example.ptkwallet.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ptkwallet.R
import com.example.ptkwallet.entities.TransactionEntity
import kotlinx.android.synthetic.main.transactionlistitem.view.*

class TransactionAdapter(val transactionlist:List<TransactionEntity>) : RecyclerView.Adapter<TransactionAdapter.ViewHolder>() {
    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v)
    {
        val txtCategory=v.findViewById<TextView>(R.id.txtCategory)
        val txtMethod = v.findViewById<TextView>(R.id.txtMethod)
        val txtAmount = v.findViewById<TextView>(R.id.txtAmount)
        val txtNotes = v.findViewById<TextView>(R.id.txtNotes)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
val v= LayoutInflater.from(parent.context).inflate(R.layout.transactionlistitem,parent,false)
        return ViewHolder(v)

    }

    override fun getItemCount(): Int {
return transactionlist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.txtCategory.text=transactionlist[position].transactionCategory
        holder.txtMethod.text=transactionlist[position].transactionMethod
        holder.txtAmount.text=transactionlist[position].transactionAmount.toString()
        holder.txtNotes.text=transactionlist[position].transactionNotes

    }
}