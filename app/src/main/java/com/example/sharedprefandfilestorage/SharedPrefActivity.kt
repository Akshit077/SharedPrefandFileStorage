package com.example.sharedprefandfilestorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SharedPrefActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)
        val sharedPreferences = this.getPreferences(Context.MODE_PRIVATE)
        findViewById<Button>(R.id.sharedPrefSubmitBtn).setOnClickListener {
            val editfile = sharedPreferences.edit()
            val textToPut: String? = findViewById<EditText>(R.id.sharedPrefEditText).text.toString()
            if (textToPut.isNullOrEmpty()) {
                Toast.makeText(this, "Please enter text", Toast.LENGTH_LONG).show()
            }
            else {
                findViewById<EditText>(R.id.sharedPrefEditText).text.clear()
                editfile.putString("SHARED_PREFERENCE_TEXT", textToPut)
                editfile.apply()
                Toast.makeText(this, "Press Retrieve button", Toast.LENGTH_LONG).show()
            }
        }
        findViewById<Button>(R.id.sharedPrefRetrieveBtn).setOnClickListener {
            val retrieveSharedPref = sharedPreferences.getString("SHARED_PREFERENCE_TEXT", "")
            if (retrieveSharedPref.isNullOrEmpty()) {
                Toast.makeText(this, "Please Enter text", Toast.LENGTH_LONG).show()
            }
            else {
                findViewById<EditText>(R.id.sharedPrefEditText).setText(retrieveSharedPref)
            }
        }
    }
}