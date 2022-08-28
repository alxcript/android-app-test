package com.example.mcmmcd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val calculateButton = findViewById<Button>(R.id.bt_calculate)
        calculateButton.setOnClickListener {
            val intent = Intent(this,ShowValuesActivity::class.java)
            val editText1 = findViewById<EditText>(R.id.et_value1)
            val editText2 = findViewById<EditText>(R.id.et_value2)
            intent.putExtra("val1", editText1.text)
            intent.putExtra("val2", editText2.text)
            startActivity(intent)
        }

    }
}