package com.example.playerapp.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.adapter.AlbumAdapter.AlbumViewHolder
import com.example.playerapp.models.AlbumModel
import com.example.playerapp.R
import com.example.playerapp.SongsActivity

class AlbumAdapter: RecyclerView.Adapter<AlbumViewHolder>(){

    private val items = mutableListOf<AlbumModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(collection: List<AlbumModel>) {
        items.clear()
        items.addAll(collection)
        notifyDataSetChanged()
    }

    inner class AlbumViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        private val albumNameLabel: TextView = itemView.findViewById(R.id.item_title)
        private val albumImage: ImageView = itemView.findViewById(R.id.item_image)

        fun bind(model: AlbumModel) {
            albumNameLabel.text = model.name
            albumImage.setImageResource(model.imageResourceId)

            itemView.setOnClickListener {
                val intent = Intent(itemView.context, SongsActivity::class.java)

                intent.putExtra(SongsActivity.hashKeySongId, model.id)

                intent.putExtra(SongsActivity.hashKeyAlbumName, model.name)

                itemView.context.startActivity(intent)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val layout : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.album_item, parent, false)

        return AlbumViewHolder(layout)

    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(items[position])

    }

    override fun getItemCount(): Int = items.size

}