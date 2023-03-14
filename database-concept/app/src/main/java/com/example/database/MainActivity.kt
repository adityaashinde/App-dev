package com.example.database

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewDatabase
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val signInButton = findViewById<Button>(R.id.btnSignUp)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etUniqueId = findViewById<TextInputEditText>(R.id.etUniqueId)

        signInButton.setOnClickListener {

            val name = etName.text.toString()
            val mail = etEmail.text.toString()
            val uniqueId = etUniqueId.text.toString()
            val password = etPassword.text.toString()


            val users = Users(name, mail, password, uniqueId)
            database = FirebaseDatabase.getInstance().getReference("Users")

            database.child(uniqueId).setValue(users).addOnSuccessListener {

                Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

            }
        }

    }
}