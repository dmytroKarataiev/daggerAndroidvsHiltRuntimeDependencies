package com.example.dagger2vshilt

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.free).setOnClickListener {
            startActivity(Intent(this, FreeActivity::class.java))
        }
        findViewById<Button>(R.id.paid).setOnClickListener {
            startActivity(Intent(this, PaidActivity::class.java))
        }
    }

}