package com.example.sharedprefandfilestorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.FileInputStream

class FileStorage : AppCompatActivity() {

    companion object {
        const val FILE_NAME = "kps"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_file_storage)

        findViewById<Button>(R.id.fileStorageWriteBtn).setOnClickListener {
            writeToFile()
        }

        findViewById<Button>(R.id.fileStorageReadBtn).setOnClickListener {
            readFromFile()
        }

    }

    private fun readFromFile() {
        try {
            val fileInputStream: FileInputStream = openFileInput(FILE_NAME)
            var strText = ""
            var ch: Int
            while (fileInputStream.read().also { ch = it } != -1) {
                strText += ch.toChar().toString()
            }
            if (strText.isEmpty()) {
                Toast.makeText(this, "Please Enter Text", Toast.LENGTH_LONG).show()
            } else {
                findViewById<EditText>(R.id.fileStorageEditText).setText(strText)
            }
            fileInputStream.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun writeToFile() {
        try {
            val fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE)
            val textToWrite: String? = findViewById<EditText>(R.id.fileStorageEditText).text.toString()
            if (!textToWrite.isNullOrEmpty()) {
                findViewById<EditText>(R.id.fileStorageEditText).text!!.clear()
                fileOutputStream.write(textToWrite.toByteArray())
                fileOutputStream.close()
                Toast.makeText(this, "Press Read button", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Please Enter text", Toast.LENGTH_LONG).show()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}