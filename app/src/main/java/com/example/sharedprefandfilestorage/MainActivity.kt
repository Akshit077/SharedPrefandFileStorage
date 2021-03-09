package com.example.sharedprefandfilestorage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.sharedPrefBtn).setOnClickListener {
            startActivity(Intent(this, SharedPrefActivity::class.java))
            Toast.makeText(this,"You Pressed Shared Preference Button", Toast.LENGTH_LONG).show()
        }

        findViewById<Button>(R.id.fileStorageBtn).setOnClickListener {
            startActivity(Intent(this, FileStorage::class.java))
            Toast.makeText(this,"You Pressed File Storage Button",Toast.LENGTH_LONG).show()
        }
    }
}
