package com.example.apuntesandriod.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.apuntesandriod.R

class SecondScreeen : ComponentActivity() {

    companion object{
        public const val ExtraText = "testString"
    }


    val backButton by lazy {findViewById<ImageButton>(R.id.back_bt)}
    val secondText by lazy {findViewById<TextView>(R.id.second_text)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_screen)

        backButton.setOnClickListener{
            finish()
        }

        secondText.text = intent.getStringExtra(ExtraText)
    }
}