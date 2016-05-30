package com.example.volleydemo;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import android.content.Context;

public abstract class VolleyInterface {

	public Context mContext;
	public static  Listener<String> mListener;
	public static ErrorListener mErrorListener;

	public VolleyInterface(Context context, Listener<String> listener,
			ErrorListener errorListener) {

		this.mContext = context;
		VolleyInterface.mListener = listener;
		VolleyInterface.mErrorListener = errorListener;

	}
	
	public abstract void onMySuccess(String resault);
	public abstract void onMyError(VolleyError error);

	public Listener<String> loadingListerner() {

		mListener = new Listener<String>() {

			@Override
			public void onResponse(String response) {
				
				//弹出加载中
				onMySuccess(response);
				
				
			}
		};

		return mListener;

	}
	
	public ErrorListener errorListener(){
		
		mErrorListener = new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				onMyError(error);	
				//提示请求失败
			}
		};	
		return mErrorListener;
	}
}
