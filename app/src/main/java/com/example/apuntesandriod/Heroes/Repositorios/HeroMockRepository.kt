package com.example.apuntesandriod.Heroes.Repositorios

import com.example.apuntesandriod.Heroes.HeroData

class HeroMockRepository: heroRepository {

    companion object{
        private val heroesListHardcoded = mutableListOf(
            HeroData("Aquaman", "asdf"),
            HeroData("superman", "dasf"),
            HeroData("superman", "dasf"),
            HeroData("superman", "dasf"),
            HeroData("superman", "dasf"),
            HeroData("superman", "dasf"),
            HeroData("superman", "dasf"),
            HeroData("femboy", "asdfasd"),
            HeroData("femboy", "asdfasd"),
            HeroData("femboy", "asdfasd"),
            HeroData("femboy", "asdfasd"),
            HeroData("furro", "asdfasdf")
        )
    }

    override suspend fun GetHeroes(offset: Int, limit: Int ): MutableList<HeroData> {
        if(heroesListHardcoded.size <= offset)
            return mutableListOf()
        if(heroesListHardcoded.size <= offset + limit)
            return heroesListHardcoded.subList(offset, heroesListHardcoded.size -1)
        return heroesListHardcoded.subList(offset, offset+limit)

    }

}