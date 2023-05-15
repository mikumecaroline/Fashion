package com.example.fashiondesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var firstname: EditText
    lateinit var lastname: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirm: EditText
    lateinit var create: Button

    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        firstname = findViewById(R.id.edtfirst)
        lastname = findViewById(R.id.edtlast)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        confirm = findViewById(R.id.edtconfirm)
        create = findViewById(R.id.btn_create)

        //intialize firebase again
        auth = FirebaseAuth.getInstance()

        confirm.inputType=InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD


        create.setOnClickListener {
            var first = firstname.text.toString().trim()
            var last = lastname.text.toString().trim()
            var email = email.text.toString().trim()
            var password = password.text.toString().trim()

            //validate inputs
            if (first.isEmpty() || last.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the field is empty", Toast.LENGTH_SHORT).show()
            } else {
                auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this) {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfuly", Toast.LENGTH_SHORT).show()
                        var gotologin = Intent(this, LoginActivity::class.java)
                        finish()
                    } else {
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}