package com.example.apuntesandriod

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apuntesandriod.ui.theme.ApuntesAndriodTheme

class MainActivity : ComponentActivity() {
    enum class Animals(){
        Dog,Cat,Panda,Fox
    }

    open class Fruit(val name:String = "FurtaGenerica"){

    }

    class Apple(): Fruit("manzana"){
        fun AppleFunc(){

        }
    }
    class Banana(): Fruit("Banana"){
        fun BananaFunc(){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesAndriodTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column() {
                        val animal = Animals.Panda
                        when(animal){
                            Animals.Dog -> PrintOnScreen(name = "Es un Panda")
                            Animals.Cat -> PrintOnScreen(name = "Es un gato")
                            Animals.Panda -> PrintOnScreen(name = "Es un Panda")
                            Animals.Fox -> PrintOnScreen(name = "Es un zorro")
                        }
                        var fruit: Fruit = Apple()

                        when(fruit){

                            is Banana -> {
                                fruit.BananaFunc()
                            }
                            is Apple ->{
                                fruit.AppleFunc()
                            }
                            else -> {

                            }
                        }
                        val str = "Lunes"


                        val numberDay = when(str){
                            "lunes" -> 0
                            "martes" -> 1
                            "miercoles" -> 2
                            else -> -1
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PrintOnScreen(name: String, modifier: Modifier = Modifier) {



    Text(
        text = "Hello ${name.uppercase()}",

    )
}
