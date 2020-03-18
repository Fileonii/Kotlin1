package com.example.zad1


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    fun submit(v: View)
    {
        val Text = findViewById<EditText>(R.id.Text)
            val name = Text.text.toString()

        val Text2= findViewById<EditText>(R.id.Text2)
            val surname = Text2.text.toString()

        val Text3 = findViewById<EditText>(R.id.Text3)
            val number = Text3.text.toString()

        Toast.makeText(this, "Witaj $name $surname!",Toast.LENGTH_LONG).show()

        val intent = Intent(this, SecoundActivity::class.java)

        intent.putExtra("user_name",name)
        intent.putExtra("user_surname",surname)
        intent.putExtra("user_number",number)

        startActivity(intent)
    }

}
