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
    enum class Colors(val text: String, val number: Int, val color: Color){
        Red("Rojo", 0, Color(255,0,0)),
        Blue("Azul", 1, Color(0,255,0)),
        Green("Verde", 2, Color(0,0,255));

        fun WithAlpha(alpha: Float):Color{
            return this.color.copy(alpha = alpha )
        }
    }

    enum class Operations(val operation: (Int, Int) -> Int){
        Add({a,b -> a + b}),
        Subtract({a,b -> a-b});
    }

    class Bt(){
       var Listeners: MutableList<(Bt) -> Int> = mutableListOf()
        fun AddOnClickListener(OnClickListener: (Bt)->Int){
                Listeners.add(OnClickListener)
        }
        fun Click(){
            for (listener in Listeners){
                listener(this)
            }

        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesAndriodTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column() {
                        var mathFunction: Operations = Operations.Add
                        var result = mathFunction.operation(1,5)

                        PrintOnScreen(name = result.toString(), color = Colors.Red)
                        val myButton = Bt()

                        myButton.AddOnClickListener{bt ->
                            Log.v("Click", "Boton Pulstado")

                        }

                        myButton.Click()
                    }
                }
            }
        }
    }
}

@Composable
fun PrintOnScreen(name: String, color: MainActivity.Colors, modifier: Modifier = Modifier) {



    Text(
        text = "Hello ${name.uppercase()}",
        modifier = Modifier,
        color = color.WithAlpha(0.5f)
    )
}
