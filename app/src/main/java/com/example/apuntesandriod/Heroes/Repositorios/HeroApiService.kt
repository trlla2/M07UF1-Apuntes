package com.example.apuntesandriod.Heroes.Repositorios

import android.os.health.TimerStat
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.ui.unit.DpOffset
import com.example.apuntesandriod.Heroes.HeroData
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class HeroApiService: heroRepository {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com:443/v1/public/"
        const val API_KEY = "11effa7c70d7581ace9e8d65df9ba17e"
        const val PRIVATE_KEY = "5957d1b057c8d3f5b08cbddf2e63916c943e462e"

        val Timestamp: String get() = Timestamp(System.currentTimeMillis()).time.toString()

        val Hash: String get(){
            val input = "$Timestamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            val finalHash = BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
            return finalHash
        }

        val ApiService: RetrofitHeroApiService by lazy{
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(RetrofitHeroApiService::class.java)
        }

    }
    interface RetrofitHeroApiService{
        @GET("characters")
        suspend fun GetHeroes(
            @Query("ts") timestamp: String = Timestamp,
            @Query("apikey") apiKey: String = API_KEY,
            @Query("hash") hash:String = Hash,
            @Query("offset")offset: Int,
            @Query("limit")limit: Int
        ): Response<CharactersResponse>
    }
    override suspend fun GetHeroes(offset: Int, limit: Int): MutableList<HeroData> {
        val response = ApiService.GetHeroes(offset = offset, limit = limit)

        if(response.isSuccessful){
            response.body()?.data?.results?.let {heroes ->
                return heroes
            }?: kotlin.run{
                //Gestionar aviso de que no hemos recivido los datos
                return mutableListOf()
            }
        }else{
            //Gestionar aviso de que no ha funcionado por algun motivo
            return mutableListOf()
        }

        return mutableListOf()
    }

}