package com.example.convertunit.activities.start_activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convertunit.R
import com.example.convertunit.activities.MainActivity
import com.example.convertunit.activities.utils.ToastFile
import com.example.convertunit.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var userName: String
    private lateinit var userPassword: String
    private lateinit var toastFile: ToastFile
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        context = this

        initComponents()
        actionsButtons()
    }

    private fun initComponents () {
        toastFile = ToastFile()
    }

    private fun getDataInput () {
        userName = binding.tfUserName.text.toString()
        userPassword = binding.tfUserPassword.text.toString()
    }

    private fun verifyDataInput () {
        getDataInput()
        val string: String
        if (userName.isEmpty() || userPassword.isEmpty()) {
            string = getString(R.string.wtfVoid)
            toastFile.toastyWarning(context, string)
        } else if (userName.length < 3 || userPassword.length <8){
            verifyCharLength()
        } else {
            startActivity(Intent(context, MainActivity::class.java))
            finish()
        }
    }

    private fun verifyCharLength () {
        val string: String
        if (userName.length < 3 && userPassword.length >= 8) {
            string = getString(R.string.wtfMinCharUserName)
            toastFile.toastyWarning(context, string)
        } else if (userPassword.length < 8 && userName.length >= 3) {
            string = getString(R.string.wtfMinCharUserPassword)
            toastFile.toastyWarning(context, string)
        } else {
            string = getString(R.string.wtfMinCharGeneral)
            toastFile.toastyWarning(context, "Debe aceptar los terminos")
        }
    }

    private fun actionsButtons () {
        pressLogIn()
        pressCreateAccount()
    }

    private fun pressLogIn () {
        binding.btnLogIn.setOnClickListener {
            verifyDataInput()
        }
    }

    private fun pressCreateAccount () {
        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(context, RegisterActivity::class.java))
        }
    }

}