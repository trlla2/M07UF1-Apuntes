package com.example.apuntesandriod.Heroes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesandriod.Heroes.Repositorios.heroRepository
import com.example.apuntesandriod.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HeroAdapter(private val repository: heroRepository, private val paginationSize: Int = 20): RecyclerView.Adapter<HeroViewHolder>() {
   private var heroList: MutableList<HeroData> = mutableListOf()
    private val provider: HeroProvider = HeroProvider(repository)
    private var requestingData: Boolean = false
    init{
        GetMoreHeroes()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HeroViewHolder(layoutInflater.inflate(R.layout.hero_cell, parent, false))
    }

    override fun getItemCount(): Int = heroList.size


    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        holder.SetupCellWithHero(heroList[position])
        if(position >= heroList.size - paginationSize){
            GetMoreHeroes()
        }
    }

    private fun GetMoreHeroes(){
        if(requestingData)
            return
        requestingData = true
        CoroutineScope(Dispatchers.IO).launch{
            var extraHeroes = provider.GetHeroes(heroList.size, paginationSize)

            CoroutineScope(Dispatchers.Main).launch {
                heroList.addAll(extraHeroes)
                notifyDataSetChanged()
                requestingData = false
            }


        }
    }

}