package com.example.fashiondesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class RegisterActivity : AppCompatActivity() {
    lateinit var fullname: EditText
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var confirm: EditText
    lateinit var create: Button

    //initialize firebase
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        fullname = findViewById(R.id.edtfirst)
        email = findViewById(R.id.edt_email)
        password = findViewById(R.id.edt_password)
        confirm = findViewById(R.id.edtconfirm)
        create = findViewById(R.id.btn_create)

        //intialize firebase again
        auth = FirebaseAuth.getInstance()

        confirm.inputType=InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD

        create.setOnClickListener {
            var name = fullname.text.toString().trim()
            var email = email.text.toString().trim()
            var password = password.text.toString().trim()

            //validate inputs
            if (name.isEmpty () ||  email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One of the field is empty", Toast.LENGTH_SHORT).show()
            } else {
                //create a user in firebase
                auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this) {

                    if (it.isSuccessful) {
                        Toast.makeText(this, "User Created Successfully", Toast.LENGTH_SHORT).show()
                        var gotologin = Intent(this,LoginActivity::class.java)
                        startActivity(gotologin)
                        finish()
                    } else{
                        Toast.makeText(this, "Failed to create account", Toast.LENGTH_SHORT).show()
                    }
                }

            }
        }
    }
}