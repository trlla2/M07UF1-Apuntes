package com.example.apuntesandriod.Heroes.Repositorios

import com.example.apuntesandriod.Heroes.HeroData

interface heroRepository {

    suspend fun GetHeroes(offset: Int, limit: Int ): MutableList<HeroData>

}