package com.example.shiba.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.shiba.myapp.util.ObservableProperty


public class MainActivity2 : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		val linearlayout2 = LinearLayout(this)
		linearlayout2.setOrientation(LinearLayout.VERTICAL)
		setContentView(linearlayout2)

		val count = ObservableProperty(0)


		val addButton = Button(this)
		addButton.setText("add 1")
		linearlayout2.addView(addButton)
		addButton.setOnClickListener{Unit ->
			count.setValue(count.getValue() + 1)
		}

		val minusButton = Button(this)
		minusButton.setText("minus 1")
		linearlayout2.addView(minusButton)
		minusButton.setOnClickListener{Unit ->
			count.setValue(count.getValue() - 1)
		}

		val scoreView = TextView(this)
		linearlayout2.addView(scoreView)
		count.sub().subscribe{v -> scoreView.setText(v.toString() + "点だよ")}

		val backButton = Button(this)
		backButton.setText("back")
		linearlayout2.addView(backButton)
		backButton.setOnClickListener{v ->
			val intent = Intent(this, javaClass<MainActivity>())
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP + Intent.FLAG_ACTIVITY_SINGLE_TOP)
			startActivity(intent)
		}
		Log.e("shiba", "last")
		count.setValue(0)
	}
}