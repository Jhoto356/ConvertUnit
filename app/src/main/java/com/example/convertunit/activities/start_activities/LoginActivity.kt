package com.example.convertunit.activities.start_activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convertunit.R
import com.example.convertunit.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

}