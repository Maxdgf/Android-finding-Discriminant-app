package com.example.draft

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.io.Serializable

lateinit var btnPrevious: Button
lateinit var inputA: EditText
lateinit var inputB: EditText
lateinit var inputD: EditText
lateinit var x1x2: TextView
lateinit var btnsolution: Button
lateinit var btnneext: Button
lateinit var btnCopy2: Button

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_main)

        btnPrevious = findViewById(R.id.back)
        inputA = findViewById(R.id.inputa)
        inputB = findViewById(R.id.inputb)
        inputD = findViewById(R.id.inputd)
        x1x2 = findViewById(R.id.answerx1x2)
        btnsolution = findViewById(R.id.solve2)
        btnneext = findViewById(R.id.neext)
        btnCopy2 = findViewById((R.id.copy2))

        fun discriminantSolutionsX1X2(): Serializable {
            val input1 = inputA.text.toString()
            val input2 = inputB.text.toString()
            val input3 = inputD.text.toString()

            val logerror = "no roots finded!"

            if (input1.isEmpty() || input2.isEmpty() || input3.isEmpty()) {
                return 0
            }

            if (input1.isEmpty()) {
                return 0
            }

            if (input2.isEmpty()) {
                return 0
            }

            if (input3.isEmpty()) {
                return 0
            }

            val a: Int = input1.toInt()
            val b: Int = input2.toInt()
            val d: Int = input3.toInt()

            if ((d != null && d < 0)) {
                return logerror
            }

            val number = d
            val root = kotlin.math.sqrt(number.toDouble())
            val x1 = (-b + root) / (2 * a)
            val x2 =  (-b - root) / (2 * a)
            return Pair(x1, x2)
        }


        btnPrevious.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnneext.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }

        btnsolution.setOnClickListener {
            x1x2.text = discriminantSolutionsX1X2().toString()
        }

        btnCopy2.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text = x1x2.text.toString()
            val clipData = ClipData.newPlainText("text", text)
            clipboardManager.setPrimaryClip(clipData)

        }

    }


