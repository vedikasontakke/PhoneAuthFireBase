package com.example.phoneauthfirebase

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()

        signOut.setOnClickListener {

            // for signing out from the app
            mAuth.signOut()

            // moving to PhoneAuthActivity
            startActivity(Intent(this, PhoneAuthActivity::class.java))
            Toast.makeText(this, "Logged out Successfully :)", Toast.LENGTH_LONG).show()
        }
    }


    override fun onStart() {
        super.onStart()

        if (mAuth.currentUser == null) {

            // go to PhoneAuthActivity
            startActivity(Intent(this, PhoneAuthActivity::class.java))
        }else {
            Toast.makeText(this, "Already Signed in :)", Toast.LENGTH_LONG).show()
        }
    }

}
