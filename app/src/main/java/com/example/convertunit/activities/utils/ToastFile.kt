package com.example.convertunit.activities.utils

import android.annotation.SuppressLint
import android.content.Context
import es.dmoral.toasty.Toasty

class ToastFile {

    @SuppressLint("CheckResult")
    fun toastyWarning (context: Context, message: String) {
        Toasty.warning(context, message, Toasty.LENGTH_SHORT).show()
    }

}