package com.zacker.appmusic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.google.android.material.tabs.TabLayoutMediator
import com.zacker.appmusic.adapter.MusicPagerAdapter
import com.zacker.appmusic.databinding.ActivityMainBinding
import com.zacker.appmusic.fragments.ArtistFragment
import com.zacker.appmusic.fragments.SongFragment
import com.zacker.appmusic.tranformer.ZoomOutPageTransformer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tabTitles = arrayOf("Song", "Album", "Artist")
        binding.vpMusic.adapter = MusicPagerAdapter(this)
        TabLayoutMediator(binding.tabMain, binding.vpMusic) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.baseline_menu_24)
        binding.vpMusic.setPageTransformer(ZoomOutPageTransformer())

        binding.navMain.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_song -> binding.vpMusic.setCurrentItem(0, true)
                R.id.menu_album -> binding.vpMusic.setCurrentItem(1, true)
                R.id.menu_artist -> binding.vpMusic.setCurrentItem(2, true)
            }
            binding.drawer.closeDrawer(GravityCompat.START)
            true
        }

//        supportFragmentManager.beginTransaction()
//            .add(R.id.fm_content, SongFragment())
//            .replace(R.id.fm_content, ArtistFragment())
//            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            if(binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
                //open
            } else {
                binding.drawer.openDrawer(GravityCompat.START)
                //close
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}