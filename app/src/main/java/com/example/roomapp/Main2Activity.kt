package com.example.roomapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.roomapp.Entities.UserDao
import com.example.roomapp.Entities.RoomUserDatabase
import com.example.roomapp.Entities.User
import android.view.Gravity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    private var db: RoomUserDatabase? = null
    private var userDao: UserDao? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val objetoIntent: Intent =intent
        var Name = objetoIntent.getStringExtra("Name")
        var Email = objetoIntent.getStringExtra("Email")
        var Password = objetoIntent.getStringExtra("Password")
        textOk.text = "Welcome, $Name. \nWe have sent you a confirmation email to $Email"

        db = RoomUserDatabase.getAppDataBase(context = this)
        userDao = db?.RoomUserDao()

        var user1 = User(name=Name, email=Email, password =Password )

        with(userDao){
            this?.insertUser(user1)
            val a= this?.getUsers()?.last()

            if (a != null) {
                textData.text ="DB INFO -> User : $a"
                val myToast = Toast.makeText(applicationContext,"User Registered Correctly",Toast.LENGTH_SHORT)
                myToast.setGravity(Gravity.LEFT,200,200)
                myToast.show()
            }

        }
    }
}
