package com.usk.mathbasicgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    lateinit var textScore : TextView
    lateinit var textLife : TextView
    lateinit var textTime : TextView

    lateinit var  textQuestion : TextView
    lateinit var editTextAns : EditText

    lateinit var buttonOk : Button
    lateinit var buttonNext : Button

    var addResult = 0
    var score = 0
    var lifeCount = 5;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        textScore = findViewById(R.id.scoreTextView)
        textLife = findViewById(R.id.lifeTextView)
        textTime = findViewById(R.id.timeTextView)

        textQuestion = findViewById(R.id.QTextView)
        editTextAns = findViewById(R.id.ansEditText)

        buttonOk = findViewById(R.id.okButton)
        buttonNext = findViewById(R.id.nextButton)

        generateQuestion()

        buttonOk.setOnClickListener {

            val input = editTextAns.text.toString()
            if(input == ""){
                Toast.makeText(applicationContext, "Plz enter answer...", Toast.LENGTH_LONG).show()
            }else{
                var inputInt = input.toInt()

                if(addResult == inputInt){
                    score+=10
                    textQuestion.text = "Thats Correct answer..."
                    textScore.text = score.toString()
                }else{
                    lifeCount--
                    textLife.text = lifeCount.toString()
                    textQuestion.text = "Thats Wrong answer..."
                }

            }


        }

        buttonNext.setOnClickListener {
            generateQuestion()
            editTextAns.setText("")
        }

    }

    fun generateQuestion(){
        val num1 = Random.nextInt(1, 99)
        val num2 = Random.nextInt(1, 99)

        addResult = num1 + num2

        textQuestion.text = "$num1 + $num2"


    }
}