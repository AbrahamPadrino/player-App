package com.example.playerapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.adapter.SongAdapter.SongsViewHolder
import com.example.playerapp.R
import com.example.playerapp.models.SongModel

class SongAdapter: RecyclerView.Adapter<SongsViewHolder>() {

    private val items = mutableListOf<SongModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun addItems(collection: List<SongModel>) {
        items.clear()
        items.addAll(collection)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongsViewHolder {
        val layout : View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.song_item, parent, false)

        return SongsViewHolder(layout)
    }

    override fun onBindViewHolder(holder: SongsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class SongsViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        private val songNameLabel: TextView = itemView.findViewById(R.id.tvSongName)
        private val songPositionLabel: TextView = itemView.findViewById(R.id.tvSongPosition)
        private val songDurationLabel: TextView = itemView.findViewById(R.id.tvSongDuration)

        fun bind(model: SongModel) {
            val parsedSongPosition: String = (adapterPosition + 1).toString()
            songPositionLabel.text = parsedSongPosition
            songDurationLabel.text = model.duration.toString()
            songNameLabel.text = model.name

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Playing song: ${model.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

}