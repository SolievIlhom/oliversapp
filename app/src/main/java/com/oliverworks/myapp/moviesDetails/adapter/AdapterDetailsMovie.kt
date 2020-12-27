package com.oliverworks.myapp.moviesDetails.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.oliverworks.myapp.R
import com.oliverworks.myapp.data.classes.Actor


class AdapterDetailsMovie : RecyclerView.Adapter<AdapterDetailsMovie.ViewHolder>() {
    private var listActors: List<Actor> = mutableListOf()
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.view_holder_actor, parent, false)
        context = view.context
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            val actor: Actor = listActors[position]
            nameActor.text = actor.name
            Glide.with(context)
                .load(actor.picture)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(avatar)
        }
    }

    override fun getItemCount(): Int = listActors.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.imageViewViewHolderActorFace)
        val nameActor: TextView = itemView.findViewById(R.id.textViewViewHolderActorName)
    }

    fun bindActors(list: List<Actor>) {
        listActors = list
        notifyDataSetChanged()
    }
}