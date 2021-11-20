package com.example.vpking.vizipipak

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.vpking.R
import com.example.vpking.dao.VizipipaSave
import kotlinx.android.synthetic.main.item_vizipipa.view.*


class VizipipaAdapter(
    private val vizipipak: MutableList<VizipipaSave>
) : RecyclerView.Adapter<VizipipaAdapter.VizipipaViewHolder>() {
    class VizipipaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VizipipaViewHolder {
        return VizipipaViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_vizipipa,
                parent,
                false
            )
        )
    }

    fun addVizipipa(vizipipaSave: VizipipaSave){
        vizipipak.add(vizipipaSave)
        notifyItemInserted(vizipipak.size-1)
    }

    fun deleteVizipipa(){
        vizipipak.removeAll { vizipipaData ->
            vizipipaData.isChecked
        }
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvVizipipa: TextView, isChecked: Boolean){
        if(isChecked){
            tvVizipipa.paintFlags = tvVizipipa.paintFlags or STRIKE_THRU_TEXT_FLAG
        }else{
            tvVizipipa.paintFlags = tvVizipipa.paintFlags or STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: VizipipaViewHolder, position: Int) {
        val curVizipipa = vizipipak[position]
        holder.itemView.apply {
            tvVizipipa.text = curVizipipa.nev
            cbSelected.isChecked = curVizipipa.isChecked
            toggleStrikeThrough(tvVizipipa, curVizipipa.isChecked)
            cbSelected.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvVizipipa, isChecked)
                curVizipipa.isChecked = !curVizipipa.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return vizipipak.size
    }
}