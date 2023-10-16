package com.example.apuntesandriod.Heroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesandriod.R

class HeroAdapter(private val heroList: List<HeroData>): RecyclerView.Adapter<HeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))
    }

    override fun getItemCount(): Int = heroList.size


    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetupCellWithHero(heroList[position])
    }
}