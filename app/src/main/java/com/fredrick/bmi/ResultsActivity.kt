package com.fredrick.bmi

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode
import java.text.DecimalFormat

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        val bundle: Bundle? = intent.extras
        val bmi = bundle!!.getDouble("bmi")


        val resultsTextView: TextView = findViewById(R.id.results_id)
        resultsTextView.setText(round(bmi).toString())


    }

    fun round(number: Double): Double? {
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.FLOOR
        return df.format(number).toDouble()
    }


}

