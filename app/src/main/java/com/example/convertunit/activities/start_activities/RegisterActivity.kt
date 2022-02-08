package com.example.convertunit.activities.start_activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.convertunit.R
import com.example.convertunit.activities.MainActivity
import com.example.convertunit.activities.utils.ToastFile
import com.example.convertunit.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var userName: String
    private lateinit var userPassword: String
    private lateinit var userPasswordConfirm: String
    private lateinit var toastFile: ToastFile
    private lateinit var context: Context
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var pinCode: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = this

        initComponents()

        actionsButtons()

    }

    private fun initComponents() {
        toastFile = ToastFile()
    }

    private fun getDataInput() {
        userName = binding.tfUserName.text.toString()
        userPassword = binding.tfUserPassword.text.toString()
        userPasswordConfirm = binding.tfUserPasswordConfirm.text.toString()
        pinCode = binding.tfUsePinCodeBackup.text.toString()
    }

    private fun verifyDataInput() {
        getDataInput()
        val string: String
        if (userName.isEmpty() || userPassword.isEmpty() || userPasswordConfirm.isEmpty()) {
            string = getString(R.string.wtfVoid)
            toastFile.toastyWarning(context, string)
        } else if (userName.length < 3 || userPassword.length < 8) {
            verifyCharLength()
        } else {
            verifyPasswordSame()
        }
    }

    private fun verifyPasswordSame () {
        val string: String
        if (userPasswordConfirm == userPassword) {
            startActivity(Intent(context, LoginActivity::class.java))
            finish()
        } else {
            string = getString(R.string.wtfPasswordConfirmError)
            toastFile.toastyWarning(context, string)
        }
    }

    private fun verifyCharLength() {
        val string: String
        if (userName.length < 3 && userPassword.length >= 8) {
            string = getString(R.string.wtfMinCharUserName)
            toastFile.toastyWarning(context, string)
        } else if (userPassword.length < 8 && userName.length >= 3) {
            string = getString(R.string.wtfMinCharUserPassword)
            toastFile.toastyWarning(context, string)
        } else {
            string = getString(R.string.wtfMinCharGeneral)
            toastFile.toastyWarning(context, string)
        }
    }

    private fun actionsButtons() {
        pressFinishRegister()
    }

    private fun pressFinishRegister() {
        binding.btnSignIn.setOnClickListener {
            val string: String
            if (binding.cbTermCond.isChecked) {
                verifyDataInput()
            } else {
                string = getString(R.string.wtfNoTermCond)
                toastFile.toastyWarning(context, string)
            }
        }
    }

}