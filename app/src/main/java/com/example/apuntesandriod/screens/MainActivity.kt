package com.example.apuntesandriod.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apuntesandriod.Heroes.HeroAdapter
import com.example.apuntesandriod.Heroes.HeroData
import com.example.apuntesandriod.Heroes.HeroProvider
import com.example.apuntesandriod.Heroes.Repositorios.HeroMockRepository
import com.example.apuntesandriod.Heroes.Repositorios.HeroSharedDatabase
import com.example.apuntesandriod.R
import com.example.apuntesandriod.Shared
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class MainActivity : ComponentActivity() {

    val heroRecyclerView by lazy { findViewById<RecyclerView>(R.id.my_recyclerView) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        InitHeroRecylceView()
    }
    fun InitHeroRecylceView(){
        heroRecyclerView.layoutManager = LinearLayoutManager(this)
        /*val tempList = mutableListOf(
            HeroData("Test hero", "Desc"),
            HeroData("Test hero", "Desc"),
            HeroData("Test hero", "Desc"),
            HeroData("Test hero", "Desc"),
        )
        Shared.Heroes = tempList*/
        //Obtenemos la lista de heroes
        //Añadimos un nuevo heroe
        //Actualizamos la lista

        CoroutineScope(Dispatchers.IO).launch {
            val heroRepository = HeroMockRepository()//nuevo repo
            //val heroRepository = HeroSharedDatabase()//nuevo repo

            val provider = HeroProvider(heroRepository)
            val heroList = provider.GetHeroes()
            val adapter = HeroAdapter(heroList)
            // heroRecyclerView.adapter = adapter esta mal porque esta tocando un objeto de la UI fuera del hilo principal
           CoroutineScope(Dispatchers.Main).launch {
               heroRecyclerView.adapter = adapter
           }

        }
        val hero = HeroData("","")
    }
}

