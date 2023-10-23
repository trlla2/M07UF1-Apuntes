package com.example.apuntesandriod.Heroes

import com.example.apuntesandriod.Heroes.Repositorios.heroRepository

class HeroProvider(private val heroRepository: heroRepository) {
    suspend fun GetHeroes() : MutableList<HeroData>{
        return heroRepository.GetHeroes()
    }
}