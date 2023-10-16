package com.example.apuntesandriod.screens

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.apuntesandriod.R

class MainActivity : ComponentActivity() {

    val btChangeScreen by lazy {findViewById<Button>(R.id.bt_changeScreen)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        btChangeScreen.setOnClickListener{
            val newIntent = Intent(this,SecondScreeen::class.java)
            newIntent.putExtra(SecondScreeen.ExtraText, "ashashadfa suka Аутичный диджей kixabank")

            this.startActivity(newIntent)
            overridePendingTransition(R.anim.enter_from_right,R.anim.exit_to_left)
        }

    }
}

