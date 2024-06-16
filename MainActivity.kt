package com.example.discriminantfindingapp

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Button

lateinit var answer: TextView
lateinit var btn_start: Button
lateinit var info: TextView
lateinit var input1: EditText
lateinit var input2: EditText
lateinit var input3: EditText
lateinit var btn_copy: Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        answer = findViewById(R.id.answernumber)
        info = findViewById(R.id.disdata)
        btn_start = findViewById(R.id.btn_solve)
        input1 = findViewById(R.id.input_a)
        input2 = findViewById(R.id.input_b)
        input3 = findViewById(R.id.input_c)
        btn_copy = findViewById(R.id.copytoclipboard)

        fun discriminant(): Int {
            val input1 = input1.text.toString()
            val input2 = input2.text.toString()
            val input3 = input3.text.toString()

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
            val c: Int = input3.toInt()

            return (b*b-4*a*c)
        }

        fun chekDiscriminant(): String {
            val answerString = answer.text.toString()
            val answer = answerString.toIntOrNull()
            val log1 = "positive"
            val log2 = "negative"
            val log3 = "error"

            if(answer != null && answer > 0) {
                return log1
            }

            if (answer != null && answer < 0) {
                return log2
            }

            if (answer == 0) {
                return log3
            }
            return TODO("Provide the return value")
        }

        btn_start.setOnClickListener {
            answer.text = discriminant().toString()
            info.text = chekDiscriminant().toString()
        }

        btn_copy.setOnClickListener {
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val text = answer.text.toString()
            val clipData = ClipData.newPlainText("text", text)
            clipboardManager.setPrimaryClip(clipData)

        }


    }
}
