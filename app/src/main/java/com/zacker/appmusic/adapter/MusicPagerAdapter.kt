package com.zacker.appmusic.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.zacker.appmusic.fragments.AlbumFragment
import com.zacker.appmusic.fragments.ArtistFragment
import com.zacker.appmusic.fragments.SongFragment

class MusicPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity)  {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SongFragment()
            1 -> AlbumFragment()
            2 -> ArtistFragment()
            else -> throw IllegalArgumentException("Unknow fragment for position")
        }
    }
}