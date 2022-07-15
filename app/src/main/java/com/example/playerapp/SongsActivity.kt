package com.example.playerapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.playerapp.adapter.SongAdapter
import com.example.playerapp.data.DataSource

class SongsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    private val songAdapter = SongAdapter()

    private val albumId: Int
        get() = intent?.extras?.getInt(hashKeySongId) ?: 0

    private val albumName: String
        get() = intent?.extras?.getString(hashKeyAlbumName).toString()

    companion object {
        const val hashKeySongId = "has_key_song_id"
        const val hashKeyAlbumName = "has_key_album_name"

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_songs)

        recyclerView = findViewById(R.id.rvSongs)

        songAdapter.addItems(DataSource.getSongsByAlbumId(albumId))
        recyclerView.adapter = songAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)

        title = getString(R.string.detail_song) + " " + albumName
    }
}