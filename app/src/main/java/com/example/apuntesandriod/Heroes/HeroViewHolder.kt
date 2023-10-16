package com.example.apuntesandriod.Heroes

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesandriod.R

class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val name by lazy{view.findViewById<TextView>(R.id.hero_cell_title)}
    val description by lazy{view.findViewById<TextView>(R.id.her0_cell_description)}

    fun SetupCellWithHero(hero:HeroData){
        name.text = hero.name
        description.text = hero.description
    }
}