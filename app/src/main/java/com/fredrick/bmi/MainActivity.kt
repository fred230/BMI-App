package com.fredrick.bmi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    var maxHeight: Int = 230

    var bmi: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

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
        var weight = 0
        var age = 0
        var height: Int = getString(R.string.height).toInt()


        //initialize
        weightTextView.text = viewModel.weight.toString()


        //livedata for age
        viewModel.age.observe(this, Observer {
            ageTextView.text = it.toString()
        })

        viewModel.weight.observe(this, Observer {
            weightTextView.text = it.toString()
        })



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
            viewModel.updateWeightAdd()

        }

        subtractWeightBtn.setOnClickListener {
            viewModel.updateWeightSubtract()
        }


        //onclick listerner on Age

        addAgeBtn.setOnClickListener {
            viewModel.updateAgeAdd()

        }

        subtractAgeBtn.setOnClickListener {
            viewModel.updateAgeSubtract()
        }

        //onclick listerner on results button

        btn.setOnClickListener {

            fun divide(a: Int, b: Double): Double {
                return a / b
            }

            fun multiply(a: Double): Double {
                return (a / 100) * (a / 100)
            }

            weight = viewModel.weight.toString().toInt()
            bmi = divide(weight, multiply(height.toDouble()))


            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("bmi", bmi)
            startActivity(intent)
        }


    }
}


