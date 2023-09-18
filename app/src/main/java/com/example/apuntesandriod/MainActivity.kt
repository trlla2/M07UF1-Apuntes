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

    enum class Operations
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesAndriodTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column() {
                        PrintOnScreen(name = "Algo de color", color = Colors.Red)
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
