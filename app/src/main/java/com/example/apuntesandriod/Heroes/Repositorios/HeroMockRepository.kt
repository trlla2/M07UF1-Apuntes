package com.example.apuntesandriod.Heroes.Repositorios

import com.example.apuntesandriod.Heroes.HeroData

class HeroMockRepository: heroRepository {

    companion object{
        private val heroList = listOf(
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

    override suspend fun GetHeroes(): MutableList<HeroData> {
        TODO("Not yet implemented")
    }

}