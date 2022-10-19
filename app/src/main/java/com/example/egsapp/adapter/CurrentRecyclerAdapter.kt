package com.example.egsapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.egsapp.Game
import com.example.egsapp.R
import com.squareup.picasso.Picasso

class CurrentRecyclerAdapter(private val game: ArrayList<Game>): RecyclerView.Adapter<CurrentRecyclerAdapter.MyViewHolder>() {
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){ //Инициализация объектов лайаута айтемов ресайклера
        val wallpaperImage: ImageView = itemView.findViewById(R.id.wallpaperImage)
        val titleText: TextView = itemView.findViewById(R.id.titleText)
        val descText: TextView = itemView.findViewById(R.id.descText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder { //Подвязка лайаута к адаптеру ресайклера
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_item, parent, false) //Определение лайаута
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) { //Запись в айтем данных в заготовленные textview
        Picasso.get().load(game[position].imageURL).into(holder.wallpaperImage)
        holder.titleText.text = game[position].title
        holder.descText.text = game[position].description
    }

    override fun getItemCount(): Int {
        println("size of list ${game.size}")
        return game.size
    }
}