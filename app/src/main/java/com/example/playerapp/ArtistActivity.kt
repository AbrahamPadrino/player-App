package com.example.playerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.adapter.ArtistAdapter
import com.example.playerapp.data.DataSource

class ArtistActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    private val artistAdapter = ArtistAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        recyclerView = findViewById(R.id.rvArtists)

        artistAdapter.addItems(DataSource.getArtists())

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = artistAdapter
        recyclerView.setHasFixedSize(true)
    }
}