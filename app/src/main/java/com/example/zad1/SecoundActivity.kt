package com.example.zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel

import kotlin.collections.ArrayList

class SecoundActivity : AppCompatActivity() {

    var seekBarArrays= ArrayList<SeekBar>()
    var seekBarValues= ArrayList<Float>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)



        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        //val seekBar = SeekBar(this)


        val bundle: Bundle? =intent.extras
        val name = bundle!!.getString("user_name")
        val surname = bundle!!.getString("user_surname")
        val number = bundle!!.getString("user_number")

        val nameText = findViewById<TextView>(R.id.textName)
        val surnameText = findViewById<TextView>(R.id.textSurname)
        val numberText = findViewById<TextView>(R.id.textNumber)

        val avgText = findViewById<TextView>(R.id.textAvg)

        val buttonAvg = findViewById<Button>(R.id.buttonAvg)

        nameText.text = "Name: $name"
        surnameText.text = "Surname: $surname"
        numberText.text="Number of g: $number"



        val i: Int = number!!.toInt()
        println(i)



        for (x in 0 until i)
        {
            val seekBar = SeekBar(this)
            //seekBar.max =5

            seekBarArrays.add(seekBar)
            seekBarArrays[x].max=3

            linearLayout.addView(seekBar)
        }

        var x = 0
        var oceny : Float = x.toFloat()



        for (x in 0 until i){



            seekBarArrays[x].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, prog: Int, b: Boolean) {
                    // Display the current progress of SeekBar
                    val min= 2

                    seekBarValues[x] = (min + seekBarArrays[x].progress).toFloat()
                    val ocena = seekBarValues[x]
                    Toast.makeText(applicationContext,"Ocena : $ocena",Toast.LENGTH_SHORT).show()
                }


                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // Do something
                  //  Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // Do something
                    //Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
                    val min=2
                     var temp = (min + seekBarArrays[x].progress).toFloat()
                    seekBarValues.add(temp)


                }

                })

                oceny += seekBarValues[x]

        }


        buttonAvg.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v:View)
            {
                var avg =oceny/i
                avgText.text = "Srednia wynosi: $oceny / $i = $avg"

            }
        } )


    }

}



