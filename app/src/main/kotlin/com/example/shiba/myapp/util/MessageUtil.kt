package com.example.shiba.myapp.util

import android.app.Activity
import android.util.Log
import android.widget.Toast
import kotlin.platform.platformStatic

object MessageUtil {
	platformStatic fun show(activity: Activity, text: CharSequence) {
		Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
	}
}