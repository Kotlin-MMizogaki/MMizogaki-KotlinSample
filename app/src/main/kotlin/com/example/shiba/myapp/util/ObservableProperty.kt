package com.example.shiba.myapp.util

import rx.Observable
import rx.Observer
import rx.Subscription
import rx.subjects.PublishSubject


class ObservableProperty<T>(t:T) {

	private var pub:PublishSubject<T>
	private var lastVal: T

	init {
		pub = PublishSubject.create()
		lastVal = t
	}

	fun setValue(t:T){
		pub.onNext(t)
		lastVal = t
	}

	fun getValue():T{
		return lastVal
	}

	fun sub(): Observable<T> {
		return pub
	}

}