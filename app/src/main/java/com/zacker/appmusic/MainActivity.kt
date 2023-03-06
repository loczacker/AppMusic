package com.zacker.appmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zacker.appmusic.databinding.ActivityMainBinding
import com.zacker.appmusic.fragments.ArtistFragment
import com.zacker.appmusic.fragments.SongFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fm_content, SongFragment())
//            .replace(R.id.fm_content, ArtistFragment())
//            .commit()
    }

}