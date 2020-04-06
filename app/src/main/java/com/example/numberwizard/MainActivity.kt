package com.example.numberwizard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //This section set the buttons label
        var up_btn: Button = findViewById(R.id.up_btn)
        up_btn.setText(R.string.up_btn)
        var down_btn: Button = findViewById(R.id.down_btn)
        down_btn.setText(R.string.down_btn)
        var restart_btn: Button = findViewById(R.id.restart_btn)
        restart_btn.setText("Restart")
        var right_btn: Button = findViewById(R.id.right_btn)
        right_btn.setText(R.string.right_btn)
        var result: TextView = findViewById(R.id.result_txv)
        var instructions: TextView = findViewById(R.id.instructions)
        instructions.setText("Instrucciones:\n Debes elegir un número entero entre 1 y 1000")
        var message: TextView = findViewById(R.id.message)



        var wizar = Wizard()
        var generalStatus = "playing"
        var userAction = ""

        //show "Your number is 'n' "
        result.setText(wizar.getPivot().toString())
        message.setText("Este es tu número?")

        fun play (status: String, userAction: String){

            if (status.equals("playing")){
                //we'll choose an option base on users action
                if(userAction.equals("restart")){
                    wizar.restart()
                    result.setText(wizar.getPivot().toString())
                    generalStatus = "playing"
                    message.setText("Vamos a intentarlo de nuevo")
                }else if (userAction.equals("right")){
                    generalStatus = "end"
                    result.setText("Soy la mejor IA")
                    message.setText("Para jugar de nuevo puedes pulsar el boton Restart")
                }else {
                    if (!wizar.indexesAreEquals()) {
                        if (userAction.equals("up")) {
                            wizar.setIndices("up")
                            result.setText(wizar.getPivot().toString())
                            message.setText("Dejame pensar")
                        } else if (userAction.equals("down")) {
                            wizar.setIndices("down")
                            result.setText(wizar.getPivot().toString())
                            message.setText("Interesante")
                        }
                    } else {
                        //you have chosen an option out of scope
                        result.setText("Hey, elegiste un número no valido, eres una deshonra")
                        generalStatus = "end"
                    }
                }
            }else if(userAction.equals("restart")){
                wizar.restart()
                result.setText(wizar.getPivot().toString())
                generalStatus = "playing"
                message.setText("Vamos a intentarlo de nuevo")
            }
        }

        up_btn.setOnClickListener{ userAction = "up" ; play(generalStatus, userAction)}
        down_btn.setOnClickListener{ userAction = "down" ;  play(generalStatus,userAction)}
        restart_btn.setOnClickListener{ userAction = "restart" ;  play(generalStatus, userAction)}
        right_btn.setOnClickListener{ userAction = "right" ; play(generalStatus, userAction)}

    }

    override fun onClick(v: View?) {}
}
