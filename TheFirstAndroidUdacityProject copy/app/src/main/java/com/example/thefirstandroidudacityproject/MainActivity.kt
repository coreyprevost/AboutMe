package com.example.thefirstandroidudacityproject

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.example.thefirstandroidudacityproject.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    private val myName:MyName = MyName("Corey Prevost")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //set click listener for button to addNickname
        // findViewById<Button>(R.id.btn_Done).setOnClickListener {
        //  addNickName(it)
        binding.btnDone.setOnClickListener { addNickName(it) }
        binding.myName = myName

    }


    //create function
    private fun addNickName(view: View) {
        binding.apply {
           tv_NickNamePlacement.text = et_NickName.text
            myName?.nickname = etNickName.text.toString()
            invalidateAll()
            //make edit text box invisible
            et_NickName.visibility = View.GONE
            //make done button gone
            btn_Done.visibility = View.GONE
            //sets nickname tv to visible when done button is clicked
            tv_NickNamePlacement.visibility = View.VISIBLE
        }
        //Hide Keyboard

        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}




