package com.example.fashiondesign

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var login:Button
    lateinit var register:Button
    //initialise firebase
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        email = findViewById(R.id.edtEmail)
        password = findViewById(R.id.edtPassword)
        login = findViewById(R.id.btnlogin)
        register = findViewById(R.id.btnreg)

        auth = FirebaseAuth.getInstance()

        var password = findViewById<EditText>(R.id.edtPassword)
        var showpassword = findViewById<Switch>(R.id.switch1)

        login.setOnClickListener {
            var email = email.text.toString().trim()
            var password = password.text.toString().trim()

            //validate edittexts
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Cannot Submit an Empty form", Toast.LENGTH_SHORT).show()
                }else{
                    auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this){
                        if (it.isSuccessful){
                            Toast.makeText(this, "Login Successfull", Toast.LENGTH_SHORT).show()

                            var  gotomain = Intent(this, MainActivity::class.java)
                            startActivity(gotomain)
                            finish()
                        }else{
                            Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                        }
                    }
                }


            }
        showpassword.setOnCheckedChangeListener{
            _,isChecked->
            if (isChecked){
                password.inputType=InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            }
            password.inputType=InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
        }

        register.setOnClickListener{
            var gotoregister = Intent(this, RegisterActivity::class.java)
            startActivity(gotoregister)
            finish()
        }

        }

        }



