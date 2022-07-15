package com.example.playerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.adapter.AlbumAdapter
import com.example.playerapp.data.DataSource

class AlbumActivity : AppCompatActivity() {

    private val artistName: String
        get() = intent?.extras?.getString(hashKeyArtistName).toString()

    private val artistId: Int
        get() = intent?.extras?.getInt(hashKeyArtistId) ?: 0


    companion object {
        const val hashKeyArtistName = "hash_key_artist_name"
        const val hashKeyArtistId = "hash_key_artist_id"
    }

    private lateinit var recyclerView: RecyclerView

    private val albumAdapter = AlbumAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        recyclerView = findViewById(R.id.rvAlbums)

        albumAdapter.addItems(DataSource.getAlbumByArtistId(artistId))
        recyclerView.layoutManager = GridLayoutManager(this,2)
        recyclerView.adapter = albumAdapter
        recyclerView.setHasFixedSize(true)

        Toast.makeText(this, "$artistName : $artistId", Toast.LENGTH_LONG).show()

        title = getString(R.string.detail_album) + " " + artistName

    }
}