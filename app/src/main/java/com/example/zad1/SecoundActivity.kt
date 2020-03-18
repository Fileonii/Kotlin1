package com.example.zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

import kotlin.collections.ArrayList

class SecoundActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secound)

        val linearLayout = findViewById<LinearLayout>(R.id.linearLayout)
        //val seekBar = SeekBar(this)
        var seekBarArrays= ArrayList<SeekBar>()

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



        for (x in 0 until i){



            seekBarArrays[x].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, prog: Int, b: Boolean) {
                    // Display the current progress of SeekBar
                    val min= 2


                 var ocena = (min + seekBarArrays[x].progress).toFloat()

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
                    var ocena = (min + seekBarArrays[x].progress).toFloat()

                }
            })


        }


        buttonAvg.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v:View)
            {
                //var avg = (counter/i).toFloat()
              //  avgText.text = "Srednia wynosi: $counter / $i = $avg"
            }
        } )


    }

}
