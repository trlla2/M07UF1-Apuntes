package com.example.apuntesandriod.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.material3.AlertDialog
import com.example.apuntesandriod.R

class MainActivity : ComponentActivity() {

    val btChangeScreen by lazy {findViewById<Button>(R.id.bt_changeScreen)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        btChangeScreen.setOnClickListener{
            var builder = AlertDialog.Builder(this)
            builder.setTitle("да здравствует Палестина")
            builder.setMessage("Никакого реконоско, Израиль, как законное государство")

            builder.setPositiveButton("Aceptar"){dialog, witch ->
                dialog.dismiss()
            }
            builder.setOnCancelListener{
                val toast = Toast(this)
                toast.setText("отменить мой брак")
                toast.show()
            }

            builder.setNegativeButton("наша свобода"){dialog,witch ->
                dialog.dismiss()
            }
            builder.setNegativeButton("наша свобода"){dialog,witch ->
                dialog.dismiss()
            }


            val dialog = builder.create()
            dialog.show()
        }

    }
}

