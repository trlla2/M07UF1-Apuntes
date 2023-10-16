package com.example.apuntesandriod.screens

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
            //builder.setMessage("Никакого реконоско, Израиль, как законное государство")

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
            builder.setNeutralButton("я люблю фембоев"){dialog,witch ->
                dialog.dismiss()
            }

            val options = arrayOf("Respuesta 1","Respuesta 2","Respuesta 3","Respuesta 4")
            val selectedResponses = booleanArrayOf(false,false,false,false)
            /*
            builder.setMultiChoiceItems(options,selectedResponses){dialog,witch,isChecked ->
                selectedResponses[witch] = isChecked
            }
            */
            /*val input = EditText(this)
            input.hint = "опишите здесь хиджопута"
            builder.setView(input)*/

            
            val dialog = builder.create()
            dialog.show()
        }

    }
}

