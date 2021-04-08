package com.sbaltinsoy.bootcampapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    // lateinit herhangi bir deger dondurmeden var deegiskenler tanimlamamiza yariyor
    lateinit var diceText : TextView
    lateinit var diceButton: Button
    lateinit var diceImage : ImageView
    lateinit var sendButton: Button
    lateinit var sendText : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("OnCreate Called")
        // value variable
        // val sadece bu alan icin tek atama icin
        //val var
        // alt enter otomatik import etme kisayolu
        // file -> invalidate Casches bas gelir
        // res sag tik show in explorer sonra draweble icine resimleri atiyoruz

        diceText = findViewById(R.id.diceText)
        diceButton = findViewById(R.id.diceButton)
        diceImage = findViewById(R.id.diceImage)
        sendText = findViewById(R.id.sendText)
        sendButton = findViewById(R.id.sendButton)


        val randomNumber = (1..10).random()

        diceButton.setOnClickListener(){
            changeText()
        }

        sendButton.setOnClickListener(){
            sendText()
        }

    }

    private fun sendText (){
        // 4 farkli gonderim sekli vardir
        // intent ve bundle kucuk verileri icin kullanilir
        // Serializable buyuk veriler icin
        val intent = Intent(this,SecondActivity::class.java)
        intent.putExtra("send",sendText.text.toString())
        startActivity(intent)
    }

    private fun changeText(){
        val randomNumber = (1..10).random()
        val drawableResourcec = when(randomNumber){
            1 -> R.drawable.dice1
            2 -> R.drawable.dice2
            3 -> R.drawable.dice3
            4 -> R.drawable.dice4
            5 -> R.drawable.dice5

            else ->  R.drawable.dice6
        }

        diceImage.setImageResource(drawableResourcec)

        diceText.text = randomNumber.toString()

        Toast.makeText(this,"Number : ${diceText.text}",Toast.LENGTH_SHORT).show()

    }


    // LifeCycle

    override fun onStart() {
        super.onStart()
        println("OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        println("OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        println("OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        println("OnStop Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("OnDestroy called")
    }

}