package com.example.playerapp.data


import com.example.playerapp.models.AlbumModel
import com.example.playerapp.models.ArtistModel
import com.example.playerapp.models.SongModel
import com.example.playerapp.R

object DataSource {

    fun getArtists() = listOf(
        ArtistModel(id = 234324324, name = "Tiesto"),
        ArtistModel(id = 6546897, name = "Armin Van Buuren")
    )

    fun getAlbumByArtistId(artistId: Int) = getAlbums().filter { it.artistId == artistId }

    fun getSongsByAlbumId(albumId: Int) = generateSongsForAlbums().filter { it.albumId == albumId }

    private fun getAlbums() = listOf(
        AlbumModel(id = 11, artistId = 234324324, name = "Colours", R.drawable.pngwing_com),
        AlbumModel(id = 12, artistId = 234324324, name = "In Search of Sunrise 1", R.drawable.pngwing_com__1_),
        AlbumModel(id = 13, artistId = 234324324, name = "Magik 2", R.drawable.pngwing_com__2_),
        AlbumModel(id = 52, artistId = 234324324, name = "Magik 3", R.drawable.pngwing_com__3_),
        AlbumModel(id = 435, artistId = 234324324, name = "In Search of Sunrise 5", R.drawable.pngwing_com__4_),
        AlbumModel(id = 876, artistId = 234324324, name = "Kadeiloscope", R.drawable.pngwing_com__5_),
        AlbumModel(id = 234, artistId = 234324324, name = "Just Be", R.drawable.pngwing_com__6_),
        AlbumModel(id = 333, artistId = 6546897, name = "Armin Only", R.drawable.pngwing_com__7_),
        AlbumModel(id = 444, artistId = 6546897, name = "Mirage", R.drawable.pngwing_com__8_),
        AlbumModel(id = 555, artistId = 6546897, name = "Feel Again", R.drawable.pngwing_com__9_),
        AlbumModel(id = 696, artistId = 6546897, name = "Balance", R.drawable.pngwing_com),
        AlbumModel(id = 686, artistId = 6546897, name = "Embrance", R.drawable.pngwing_com__1_),
        AlbumModel(id = 636, artistId = 6546897, name = "Imagine", R.drawable.pngwing_com__2_),
        AlbumModel(id = 525, artistId = 6546897, name = "Intense", R.drawable.pngwing_com__3_),
    )

    private fun generateSongsForAlbums(): List<SongModel> {
        val albums = getAlbums()

        val albumSongsCollection = mutableListOf<SongModel>()

        albums.forEach {
            val numberOfSongsRandomInt: Int = (4..20).random()

            for (i in 1..numberOfSongsRandomInt) {
                albumSongsCollection.add(
                    SongModel(
                        albumId = it.id,
                        id = i,
                        name = "Song - $i",
                        duration = (60..300).random().toLong()
                    )
                )
            }
        }
        return albumSongsCollection
    }

}