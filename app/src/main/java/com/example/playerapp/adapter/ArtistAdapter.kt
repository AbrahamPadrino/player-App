package com.example.playerapp.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.models.ArtistModel
import com.example.playerapp.AlbumActivity
import com.example.playerapp.AlbumActivity.Companion.hashKeyArtistId
import com.example.playerapp.AlbumActivity.Companion.hashKeyArtistName
import com.example.playerapp.R

class ArtistAdapter : RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    private val items = mutableListOf<ArtistModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(collection: List<ArtistModel>) {
        items.clear()
        items.addAll(collection)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val layout : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.artist_item, parent, false)

        return ArtistViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val artistNameLabel: TextView = itemView.findViewById(R.id.tvArtistName)

        fun bind(model: ArtistModel) {
            artistNameLabel.text = model.name

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, AlbumActivity::class.java)

                intent.putExtra(hashKeyArtistName, model.name)
                intent.putExtra(hashKeyArtistId, model.id)

                itemView.context.startActivity(intent)
            }
        }
    }

}