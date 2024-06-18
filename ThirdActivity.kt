package com.example.draft

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.TextView

lateinit var inputb2: EditText
lateinit var inputa2: EditText
lateinit var solvetwo: Button
lateinit var back2: Button
lateinit var answertwo: TextView
lateinit var btnCoping: Button

class ThirdActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.third_main)

        inputb2 = findViewById(R.id.inputb2)
        inputa2 = findViewById(R.id.inputa2)
        solvetwo = findViewById(R.id.solve23)
        back2 = findViewById(R.id.back2)
        answertwo = findViewById(R.id.answerx)
        btnCoping = findViewById(R.id.copy22)

        back2.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        fun discriminantx(): Int {
            val input1 = inputa2.text.toString()
            val input2 = inputb2.text.toString()

            if (input1.isEmpty() || input2.isEmpty()) {
                return 0
            }

            if (input1.isEmpty()) {
                return 0
            }

            if (input2.isEmpty()) {
                return 0
            }

            val a: Int = input1.toInt()
            val b: Int = input2.toInt()

            val x = (-b/(2*a))

            return x

        }

        solvetwo.setOnClickListener {
            answertwo.text = discriminantx().toString()
        }

        btnCoping.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text = answertwo.text.toString()
            val clipData = ClipData.newPlainText("text", text)
            clipboardManager.setPrimaryClip(clipData)

        }

    }


