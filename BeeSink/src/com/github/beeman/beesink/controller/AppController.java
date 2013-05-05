package com.github.beeman.beesink.controller;

import android.util.Log;

public class AppController {

	public static final String TAG = "BeeSink";

	public AppController() {
		super();
		d("AppController loaded [debug msg]");
		i("AppController loaded [info msg]");
		w("AppController loaded [warning msg]");
		e("AppController loaded [eror msg]");
		wtf("AppController loaded [wtf msg]");
	}

	public void d(String message) {
		Log.d(TAG, message);
	}

	public void i(String message) {
		Log.i(TAG, message);
	}

	public void w(String message) {
		Log.w(TAG, message);
	}

	public void wtf(String message) {
		Log.wtf(TAG, message);
	}

	public void e(String message) {
		Log.e(TAG, message);
	}

}
