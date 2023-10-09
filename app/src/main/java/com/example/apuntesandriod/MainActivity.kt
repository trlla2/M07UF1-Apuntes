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


    enum class Operation(val operation: (a:Int, b:Int)->Int, var char: String){
        Add({a,b -> a + b}, "+"),
        Sub({a,b -> a - b}, "-"),
        Mul({a,b -> a * b}, "*"),
        Div({a,b -> a / b}, "/");

        fun Operate(a: Int, b: Int): Int{
            return  this.operation(a,b)
        }
    }
    var A: Int? = null
    var B: Int? = null
    var Op: Operation? = null

    class ButtonsRow(var linearLayout: LinearLayout,val context: Context){
        var buttons: MutableList<Button> = mutableListOf()

        fun AddButtonToRow(text: String) : Button {
            var bt = Button(context)
            bt.text = text
            bt.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT,1.0f)

            linearLayout.addView(bt)
            buttons.add(bt)

            return bt
        }
    }


    class ButtonsGrid(var parent: LinearLayout, var context: Context){
        val baseLinearLayout: LinearLayout
         private var rows: MutableList<ButtonsRow> = mutableListOf()
        init {
            baseLinearLayout = LinearLayout(context)
            baseLinearLayout.orientation = LinearLayout.VERTICAL

            parent.addView(baseLinearLayout)
        }
        fun AddNewRow(){
            val linearLayout = LinearLayout(context)
            linearLayout.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT,1.0f)




            baseLinearLayout.addView(linearLayout)
            rows.add(ButtonsRow(linearLayout, context ))

        }
        fun GetRow(index: Int) : ButtonsRow?{
            if(index >= rows.count() || index < 0){
                return null
            }
            return rows[index]
        }
    }

    val result:TextView by lazy {findViewById(R.id.result)}
    val buttonsContainer:LinearLayout by lazy {findViewById(R.id.buttons_container)}
    var buttonsGrid: MutableList<LinearLayout> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_screen)

        /*val bt = Button (this)
        bt.text = "buton creado por codigo"
        bt.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)


        buttonsContainer.addView(bt)*/

        val btGrid = ButtonsGrid(buttonsContainer,this)
       /* btGrid.AddNewRow()
        var bt1 = btGrid.GetRow(0)?.AddButtonToRow("Bt1")
        bt1?.setOnClickListener{
            result.text = "1"
        }
        btGrid.GetRow(0)?.AddButtonToRow("Bt2")?.setOnClickListener{
            result.text = "2"
        }

        btGrid.GetRow(1)?.AddButtonToRow("Bt3")
        btGrid.GetRow(1)?.AddButtonToRow("Bt4")*/

        var names: MutableList<MutableList<String>> = mutableListOf()
        names.add(mutableListOf("AC", "()", "%", "/"))
        names.add(mutableListOf("7", "8", "9", "*"))
        names.add(mutableListOf("4", "5", "6", "-"))
        names.add(mutableListOf("1", "2", "3", "+"))
        names.add(mutableListOf("0", ".", "<--", "="))
        for (y in 0 .. 4){
            btGrid.AddNewRow()

            var row: ButtonsRow? = btGrid.GetRow(y)

            for(x in 0 .. 3){
                row?.AddButtonToRow(names[y][x])?.setOnClickListener {

                    when (names[y][x]) {
                        "AC" ->{
                            A = null
                            B = null
                            Op = null
                            result.text = " "
                        }
                        "+" ->{
                            OperationPress(Operation.Add)
                        }
                        "-" ->{
                            OperationPress(Operation.Sub)
                        }
                        "*" ->{
                            OperationPress(Operation.Mul)
                        }
                        "/" ->{
                            OperationPress(Operation.Div)
                        }
                        "0","1","2","3","4","5","6","7","8","9" ->{
                            NumberPress(names[y][x].toInt())
                        }
                        "=" ->{
                            A?.let  {a->
                                B?.let{b->
                                    val resultNum = Op?.Operate(a,b)
                                    result.text = resultNum.toString()
                                    A = resultNum
                                    B = null
                                    Op = null
                                }
                            }

                        }
                        else -> result.text = names[y][x]
                    }




                }
            }
        }
    }

    fun NumberPress(num: Int){
        if(Op == null){
            val a = A?.let{a ->
                A = (a * 10)+num
            }?:run {
                A = num
            }
            result.text = A.toString()
        }else{
            val b = B?.let{b ->
                B = (b * 10)+num
            }?:run {
                B = num
            }
            result.text = A.toString() +Op?.char +B.toString()

        }
    }
    fun OperationPress(op: Operation){

            if(A != null && B == null) {
                Op = op
                result.text = A.toString() + Op?.char
            }
    }

}

