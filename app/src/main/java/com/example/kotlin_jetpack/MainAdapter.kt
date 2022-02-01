package com.example.kotlin_jetpack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin_jetpack.models.Result

class MainAdapter(private var authordata:List<Result>):RecyclerView.Adapter<MainViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
       val  inflater = LayoutInflater.from(parent.context)
           .inflate(R.layout.itemview,parent,false)
        return  MainViewHolder(inflater)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
            val author = authordata[position]
        holder.title.text = author.content
//        val movie = moviesList[position]
//        holder.title.text = movie.getTitle()
    }

    override fun getItemCount(): Int {
    return authordata.size
    }
}

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
var title: TextView = view.findViewById(R.id.author)
}