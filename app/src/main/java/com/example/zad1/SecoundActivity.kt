package com.example.zad1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import java.sql.Types.NULL

import kotlin.collections.ArrayList



class SecoundActivity : AppCompatActivity() {

    var seekBarArrays= ArrayList<SeekBar>()

   // var temp= ArrayList<Int>()
    var seekBarValues= ArrayList<Int>()

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



    //    val buttonAvg = findViewById<Button>(R.id.buttonAvg)

        nameText.text = "Name: $name"
        surnameText.text = "Surname: $surname"
        numberText.text="Number of g: $number"



        val i: Int = number!!.toInt()



        for (x in 0 until i)
        {
            val seekBar = SeekBar(this)
            //seekBar.max =5

            seekBarArrays.add(seekBar)
            seekBarArrays[x].max=4

            linearLayout.addView(seekBar)
        }





        for (x in 0 until i){



            seekBarArrays[x].setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {

                override fun onProgressChanged(seekBar: SeekBar, prog: Int, b: Boolean) {
                    // Display the current progress of SeekBar
                   val min= 1

                   var ocena = min+prog
                    Toast.makeText(applicationContext, "Ocena : $ocena", Toast.LENGTH_SHORT).show()

                }


                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    // Do something
                  //  Toast.makeText(applicationContext,"start tracking",Toast.LENGTH_SHORT).show()
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    // Do something
                    //Toast.makeText(applicationContext,"stop tracking",Toast.LENGTH_SHORT).show()
                    val min = 1
                    var t = min + seekBarArrays[x].progress

                    if (seekBarValues.count() < i) {
                        seekBarValues.add(t)
                    } else
                    {
                        seekBarValues[x] = t
                    }
                       //seekBarArrays[x].isEnabled = false

                }

                })


        }




    }
    fun submit2(v:View){

        val buttonAvg = findViewById<Button>(R.id.buttonAvg)


        var x = 0
        var oceny : Float = x.toFloat()
        if( seekBarValues.isNotEmpty()){


            for(it in 0 until seekBarValues.count()){

                oceny += seekBarValues[it]
            }
        }
        var avg= (oceny/seekBarValues.count()).toFloat()

        buttonAvg.isClickable= false
        buttonAvg.text = "Srednia wynosi: $oceny / ${seekBarValues.count()} = $avg"

    }
}



//save instance
//empty seekbar
//layout
