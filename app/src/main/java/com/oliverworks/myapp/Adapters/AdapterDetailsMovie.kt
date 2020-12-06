package com.oliverworks.myapp.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.oliverworks.myapp.Classes.Actor
import com.oliverworks.myapp.R


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
            nameActor.text = listActors[position].name
            avatar.setImageDrawable(
                AppCompatResources.getDrawable(
                    context,
                    listActors[position].pathAvatar
                )
            )
        }
    }

    override fun getItemCount(): Int = listActors.size

    fun bindActors(list: List<Actor>) {
        listActors = list
        notifyDataSetChanged()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.imageViewViewHolderActorFace)
        val nameActor: TextView = itemView.findViewById(R.id.textViewViewHolderActorName)
    }
}