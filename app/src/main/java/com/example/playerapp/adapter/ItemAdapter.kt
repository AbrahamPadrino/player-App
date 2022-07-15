package com.example.playerapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.model.dataid
import com.example.playerapp.R

/**
 * Adaptador para [RecyclerView] en [MainActivity]. Muestra el objeto de datos [Afirmación].
 */

class ItemAdapter(private val context: Context, private val dataset: List<dataid>
                  ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }
    /**
     * Crear nuevas vistas (invocadas por el administrador de diseño)
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // create a new view
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.album_item, parent, false)

        return ItemViewHolder(adapterLayout)
    }
    /**
     * Reemplazar el contenido de una vista (invocado por el administrador de diseño)
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
    /**
     * Devuelve el tamaño de tu conjunto de datos (invocado por el administrador de diseño)
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}