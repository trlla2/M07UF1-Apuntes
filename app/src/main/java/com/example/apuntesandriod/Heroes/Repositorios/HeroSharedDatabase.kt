package com.example.apuntesandriod.Heroes.Repositorios

import com.example.apuntesandriod.Heroes.HeroData
import com.example.apuntesandriod.Shared

class HeroSharedDatabase: heroRepository {


    override suspend fun GetHeroes(): MutableList<HeroData> {
        return Shared.Heroes
    }

}