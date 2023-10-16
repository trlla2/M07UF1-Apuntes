package com.example.apuntesandriod.Heroes

class HeroProvider {
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

        fun GetAllHeroes() : List<HeroData> = heroList
    }
}