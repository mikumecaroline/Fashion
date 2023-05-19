package com.example.fashiondesign

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.fashiondesign.databinding.ActivityLoginBinding
import com.example.fashiondesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var userArrayList : ArrayList<User>
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageId = intArrayOf(

            R.drawable.shoes, R.drawable.jeans, R.drawable.blouse,
            R.drawable.jewelleries, R.drawable.handbags, R.drawable.dresses,
        )

        val textView2 = arrayOf(
            "shoes",
            "jeans",
            "blouse",
            "jewelleries",
            "handbags",
            "dreasses",
        )

        val lastMessage = arrayOf(
            "color:pink",
            "color:blue black",
            "color:peach black pink yellow",
            "color:gold silver",
            "color:brown black",
            "corol:red black blue",
        )

        val textView4 = arrayOf(
            "size:37-39",
            "Age:18-25yrs",
            "Age:10-20yrs",
            "Good Quality from China",
            "A leather for set of 9pieces",
            "Size:XL XXL",
        )

        val textView5 = arrayOf(
            "Price:2000",
            "Price:1500",
            "Price:800",
            "Price:5000",
            "Price:4500",
            "Price:2500",
        )
        //initialize userArrayList
        binding.listview.isClickable = true
        binding.listview.adapter = MyAdapter(this, userArrayList)
        binding.listview.setOnItemClickListener { parent, view, position, id ->

            val textView4 = textView4[position]
            val textView2 = textView2[position]
            val textView5 = textView5[position]
            val lastMessage = lastMessage[position]
            val imageView3 = imageId[position]

            val shoes = Intent(this, UserActivity::class.java)
            shoes.putExtra("textView4", textView4)
            shoes.putExtra("textview2", textView2)
            shoes.putExtra("textview5", textView5)
            shoes.putExtra("lastMessage", lastMessage)
            shoes.putExtra("imageid", imageView3)
            startActivity(shoes)

        }
    }
}