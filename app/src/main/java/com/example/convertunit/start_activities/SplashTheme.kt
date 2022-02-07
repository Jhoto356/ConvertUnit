package com.example.convertunit.start_activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convertunit.R
import java.util.concurrent.TimeUnit

class SplashTheme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        TimeUnit.SECONDS.sleep(2)

        startActivity(Intent(this, MainActivity::class.java))
    }

}