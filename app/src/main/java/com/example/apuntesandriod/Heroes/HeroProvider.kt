package com.example.apuntesandriod.Heroes

import com.example.apuntesandriod.Heroes.Repositorios.heroRepository

class HeroProvider(private val heroRepository: heroRepository) {
    suspend fun GetHeroes(offset: Int, limit: Int) : MutableList<HeroData>{
        return heroRepository.GetHeroes(offset = offset, limit = limit)
    }
}