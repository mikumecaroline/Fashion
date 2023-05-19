package com.example.fashiondesign

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter (private val context:Activity,private val arrayList: ArrayList<User>) : ArrayAdapter<User>(context,
                 R.layout.list_item,arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater :LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.list_item,null);

        val imageView3:ImageView=view.findViewById(R.id.imageView3)
        val textView2 :TextView=view.findViewById(R.id.textView2)
        val lastMessage:TextView=view.findViewById(R.id.lastMessage)
        val textView4:TextView=view.findViewById(R.id.textView4)
        val textView5:TextView=view.findViewById(R.id.textView5)

        imageView3.setImageResource(arrayList[position].imageId)
        textView2.text=arrayList[position].shoes
        lastMessage.text=arrayList[position].lastcolor
        textView4.text=arrayList[position].lastsize
        textView5.text=arrayList[position].lastprice


        return view
    }
}











