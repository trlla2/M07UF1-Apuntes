package com.example.apuntesandriod.Heroes.Repositorios

import com.example.apuntesandriod.Heroes.HeroData
import com.example.apuntesandriod.Shared

class HeroSharedDatabase: heroRepository {


    override suspend fun GetHeroes(offset: Int, limit: Int): MutableList<HeroData> {
        val heroes = Shared.Heroes

        if(heroes.size <= offset)
            return mutableListOf()
        if(heroes.size <= offset+limit)
            return heroes.subList(offset, heroes.size -1)
        return Shared.Heroes.subList(offset, offset + limit)
    }

}