package com.example.addn

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var txt: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btnSum)
        txt = findViewById(R.id.txtOutput)
        btn.setOnClickListener {
            var N: Int
            var sum: Int
            try {
                N = findViewById<EditText>(R.id.edtNum).text.toString().toInt()
                if (N < 1) {
                    txt.setText("請輸入大於1的正整數")
                    return@setOnClickListener
                }
            } catch (e: Exception) {
                txt.setText("請輸入大於1的正整數")
                return@setOnClickListener
            }
            //             -1      -1      -1      -1
            // sum = 1 + (2-3) + (4-5) + (6-7) + (8-9) + 10 - ..........
            if (N % 2 == 0) {//N為偶數 sum = 1 + N - (N - 2) / 2 = 2 + N/2
                sum = 2 + N / 2
            } else {//N為奇數
                sum = 1 - (N - 1) / 2
            }
            txt.setText("答案：" + sum.toString())
        }
    }
}
