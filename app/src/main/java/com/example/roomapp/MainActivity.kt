package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.text.TextUtils
import android.util.Patterns
import android.widget.Toast
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnviar.setOnClickListener{

            var name:String = name.text.toString()
            var email:String = email.text.toString()
            var pass:String = pass.text.toString()

            if (name == "" || email == "" || pass == "") {
                Toast.makeText(applicationContext,"Empty or wrong fields!",Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this,Main2Activity::class.java)
                intent.putExtra("Name", name)
                intent.putExtra("Email", email)
                intent.putExtra("Password", pass)
                startActivity(intent)
            }
        }

    }
}
