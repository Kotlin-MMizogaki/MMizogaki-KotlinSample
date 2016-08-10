package com.example.shiba.myapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.shiba.myapp.util.MessageUtil
import rx.subjects.PublishSubject


public class MainActivity : Activity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		//20Activity生成の決まり文句
		super.onCreate(savedInstanceState)

		//ボタンを横に並べるための親要素の生成。
		val linearlayout1 = LinearLayout(this)
		linearlayout1.setOrientation(LinearLayout.HORIZONTAL)
		setContentView(linearlayout1)

		//ボタンを作ってlinearlayout1の子として登録する。ついでにクリックイベントもおいておく。
		val displayTexts:Array<Pair<String, String>> = array(
				Pair(getResources().getString(R.string.str_button1), getResources().getString(R.string.str_buttonMessage1)),
				Pair(getResources().getString(R.string.str_button2), getResources().getString(R.string.str_buttonMessage2)),
				Pair(getResources().getString(R.string.str_button3), getResources().getString(R.string.str_buttonMessage3))
		)
		for (texts in displayTexts) {
			val button = Button(this)
			button.setText(texts.first)
			if(texts.first == getResources().getString(R.string.str_button2)){
				button.setLayoutParams(LinearLayout.LayoutParams(
						ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, 2.0f
				))
			}
			linearlayout1.addView(button)
			button.setOnClickListener{v -> MessageUtil.show(this, texts.second)}
		}


		val countSubject:PublishSubject<Int> = PublishSubject.create()
		countSubject.onNext(0);
		val addButton = Button(this)
		addButton.setText("change")
		linearlayout1.addView(addButton)
		addButton.setOnClickListener{v ->
			val intent = Intent(this, javaClass<MainActivity2>())
			intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
			startActivity(intent)
		}
	}
}