package com.davidzimmerly.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.davidzimmerly.myapplication.ui.main.BlankFragment

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, BlankFragment.newInstance())
                .commitNow()
        }

        intent?.apply {
            Toast.makeText(
                applicationContext,
                "received intent with uuid: ${getStringExtra("UUID")}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

}