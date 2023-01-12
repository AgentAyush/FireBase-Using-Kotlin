package com.ayushapp.firebaseusingkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayushapp.firebaseusingkotlin.PersonModel
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import java.text.FieldPosition

class PersonAdapter(private val personlist: ArrayList<PersonModel>) :
    RecyclerView.Adapter<PersonAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemViewlist = LayoutInflater.from(parent.context).inflate(R.layout.itemview,parent,false)
        return ViewHolder(itemViewlist)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        val currPerson = personlist[position]
        holder.tvitemslist.text = currPerson.personName
    }

    override fun getItemCount(): Int {
        return personlist.size
    }
    class ViewHolder(itemViewList : View) : RecyclerView.ViewHolder(itemViewList){
        val tvitemslist : TextView = itemViewList.findViewById(R.id.tvitemslist)
    }
}