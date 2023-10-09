package com.example.apuntesandriod

import android.app.ActionBar.LayoutParams
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
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

    val openAppText: TextView by lazy { findViewById(R.id.open_app_text) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        /*val shared = this.getSharedPreferences("MySharedPreferences",Context.MODE_PRIVATE)

        var timesOpenApp = shared.getInt("AppOpenTimes",0)

        timesOpenApp++

        openAppText.text = timesOpenApp.toString()

        val editor = shared.edit()

        editor.putInt("AppOpenTimes",timesOpenApp)
        editor.apply()

        openAppText.text = SharedPreferencesManager.Test().toString()*/

        //openAppText.text = SharedPreferencesManager.TimesOpenapp.toString()
        Shared.TimesOpenApp++
        openAppText.text = SharedPreferencesManager.TimesOpenApp.toString()
    }
}

