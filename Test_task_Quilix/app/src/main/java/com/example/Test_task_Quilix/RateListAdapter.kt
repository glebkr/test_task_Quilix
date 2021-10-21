package com.example.Test_task_Quilix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.currency_item.view.*

class RateListAdapter() : RecyclerView.Adapter<RateListAdapter.RateListViewHolder>() {
    class RateListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return RateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RateListViewHolder, position: Int) {
        holder.itemView.currency.text = "USD"
        holder.itemView.description.text = "1 доллар США"
        holder.itemView.rate1.text = "1,9264"
        holder.itemView.rate2.text = "1,9231"
    }

    override fun getItemCount(): Int {
        return 20
    }
}