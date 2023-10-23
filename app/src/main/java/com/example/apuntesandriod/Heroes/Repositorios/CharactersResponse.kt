package com.example.apuntesandriod.Heroes.Repositorios

import com.example.apuntesandriod.Heroes.HeroData
import com.google.gson.annotations.SerializedName

data class CharactersResponse(@SerializedName("code") val statusCode: String, val data: CharacterResponseData)

data class CharacterResponseData(val total: Int, val count:Int, val results: MutableList<HeroData>)
