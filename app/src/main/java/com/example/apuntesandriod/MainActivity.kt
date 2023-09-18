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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apuntesandriod.ui.theme.ApuntesAndriodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApuntesAndriodTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Column() {
                        for(i in 1..5) {
                            PrintOnScreen("null")
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        val names = listOf ("Roc","Nazi","Jordi")

                        for(name in names){
                            PrintOnScreen(name)
                        }
                        Spacer(modifier = Modifier.height(16.dp))

                        for(i in names){
                            PrintOnScreen("index: " + i.toString())
                        }

                        Spacer(modifier = Modifier.height(16.dp))
                        names.forEach{name ->
                            PrintOnScreen(name)
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                        names.forEachIndexed() {index, name->
                            PrintOnScreen(name + " " + index.toString())
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
        modifier = modifier
    )
}
