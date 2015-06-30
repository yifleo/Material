package com.github.utils;

import android.content.Context;
import android.os.Looper;
import android.widget.Toast;

public class ToastUtils {
	public static Toast showToastShort(Context context, String msg) {
		Looper myLooper = Looper.myLooper();
		Looper mainLooper = Looper.getMainLooper();
		if (myLooper == mainLooper) {
			Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
			toast.show();
			return toast;
		}
		return null;
	}

	public static Toast showToastShort(Context context, int resId) {
		Looper myLooper = Looper.myLooper();
		Looper mainLooper = Looper.getMainLooper();
		if (myLooper == mainLooper) {
			Toast toast = Toast.makeText(context, resId, Toast.LENGTH_SHORT);
			toast.show();
			return toast;
		}
		return null;
	}

	public static Toast showToastLong(Context context, String msg) {
		Looper myLooper = Looper.myLooper();
		Looper mainLooper = Looper.getMainLooper();
		if (myLooper == mainLooper) {
			Toast toast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
			toast.show();
			return toast;
		}
		return null;
	}

	public static Toast showToastLong(Context context, int resId) {
		Looper myLooper = Looper.myLooper();
		Looper mainLooper = Looper.getMainLooper();
		if (myLooper == mainLooper) {
			Toast toast = Toast.makeText(context, resId, Toast.LENGTH_LONG);
			toast.show();
			return toast;
		}
		return null;
	}
}
