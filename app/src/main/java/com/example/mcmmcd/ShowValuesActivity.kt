package com.example.mcmmcd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.TextView
import kotlin.math.max
import kotlin.math.min

class ShowValuesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_values)

        val intent = getIntent()
        val val1 = "" + (intent.extras?.get("val1") )?: ""
        val val2 = "" + (intent.extras?.get("val2") )?: ""
        var max = max(val1.toInt(), val2.toInt())
        var min = min(val1.toInt(), val2.toInt())

        var mcd = this.mcd(min, max)

        val mcm = this.mcm(min, max)

        val textView = TextView(this)
        textView.text = "MCD: $mcd | mcm: $mcm"
        textView.textSize = 25f
        val viewGroup:ViewGroup = findViewById(R.id.ly_showValues)
        viewGroup.addView(textView)

    }

    private fun mcd(_min: Int, _max: Int): Int {
        var mcd = 0
        var min = _min
        var max = _max
        do {
            mcd = min
            min = max % min
            max = mcd
        } while (min != 0)
        return mcd
    }

    private fun mcm(_min: Int, _max: Int): Int {
        return (_max / this.mcd(_min, _max)) * _min
    }

}