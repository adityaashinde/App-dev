package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewDatabase
import android.widget.Button
import android.widget.EditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signInButton = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<EditText>(R.id.etName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etUniqueId = findViewById<EditText>(R.id.etUniqueId)

        signInButton.setOnClickListener {

            val name = etName.text
            val mail = etEmail.text
            val uniqueId = etUniqueId.text
            val password = etPassword.text

            database = FirebaseDatabase.getInstance().getReference("Users")
        }

    }
}