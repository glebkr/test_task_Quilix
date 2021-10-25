package com.example.Test_task_Quilix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.Test_task_Quilix.retrofit.Currency
import kotlinx.android.synthetic.main.currency_item.view.*

class RateListAdapter(val rateTodList: MutableList<Currency>, val rateTomList: MutableList<Currency>) : RecyclerView.Adapter<RateListAdapter.RateListViewHolder>() {
    class RateListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return RateListViewHolder(view)
    }

    override fun onBindViewHolder(holder: RateListViewHolder, position: Int) {
        val curTodRate = rateTodList[position]
        val curTomRate = rateTomList[position]
        holder.itemView.currency.text = curTodRate.Cur_Abbreviation
        holder.itemView.description.text = curTodRate.Cur_Scale + " " +  curTodRate.Cur_Name
        holder.itemView.rate1.text = curTodRate.Cur_OfficialRate
        holder.itemView.rate2.text = curTomRate.Cur_OfficialRate
    }

    override fun getItemCount(): Int {
        return rateTodList.size
    }
}