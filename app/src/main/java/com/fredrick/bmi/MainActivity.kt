package com.fredrick.bmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var maxHeight: Int = 230

    var bmi: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //textviews
        val seekbar: SeekBar = findViewById(R.id.heightSeekbar)
        val textHeight: TextView = findViewById(R.id.textViewHeight)
        val weightTextView: TextView = findViewById(R.id.weightNumber)
        val ageTextView: TextView = findViewById(R.id.ageNumber)


        //imagebuttons
        val addWeightBtn: ImageButton = findViewById(R.id.weightAdd)
        val addAgeBtn: ImageButton = findViewById(R.id.ageAdd)
        val subtractAgeBtn: ImageButton = findViewById(R.id.ageSubtract)
        val subtractWeightBtn: ImageButton = findViewById(R.id.weightSubtract)
        val btn: Button = findViewById(R.id.button_result)

        //variables
        var weight: Int = getString(R.string.weight).toInt()
        var age: Int = getString(R.string.age).toInt()
        var height: Int = getString(R.string.height).toInt()
        seekbar.setMax(maxHeight)

        seekbar.setProgress(height)




        seekbar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

                textHeight.text = progress.toString()


            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

                height = seekbar.progress

            }

        })

        //onclick listerner on Weight

        addWeightBtn.setOnClickListener {


            weightTextView.text = weight++.toString()

        }

        subtractWeightBtn.setOnClickListener {

            weightTextView.text = weight--.toString()
        }


        //onclick listerner on Age

        addAgeBtn.setOnClickListener {


            ageTextView.text = age++.toString()

        }

        subtractAgeBtn.setOnClickListener {

            ageTextView.text = age--.toString()
        }

        //onclick listerner on results button

        btn.setOnClickListener {

            fun divide(a: Double, b: Double): Double {
                return a / b
            }

            fun multiply(a: Double): Double {
                return (a / 100) * (a / 100)
            }


            bmi = divide(weight.toDouble(), multiply(height.toDouble()))


            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("bmi", bmi)
            startActivity(intent)
        }


    }
}


