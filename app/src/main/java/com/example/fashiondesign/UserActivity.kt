package com.example.fashiondesign

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fashiondesign.databinding.ActivityMainBinding
import com.example.fashiondesign.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val shoes = intent.getStringExtra("shoes")
        val size = intent.getStringExtra("sun.awt.X11.XSizeHints")
        val price = intent.getStringExtra("price")
        val imageid = intent.getIntExtra("imageid", R.drawable.shoes)


    }
}