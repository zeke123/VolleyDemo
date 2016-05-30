package com.example.volleydemo;

import java.util.Map;

import android.content.Context;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.toolbox.StringRequest;

public class VolleyRequest {

	public static StringRequest stringRequest;

	public static Context mContext;

	public static void requestGet(Context mContext, String url, String tag,
			VolleyInterface volleyInterface) {
		MyApplication.getHttpQueues().cancelAll(tag);

		stringRequest = new StringRequest(Method.GET, url,
				volleyInterface.loadingListerner(),
				volleyInterface.errorListener());
		stringRequest.setTag(tag);
		MyApplication.getHttpQueues().add(stringRequest);
		MyApplication.getHttpQueues().start();
	}

	public static void requestPost(Context mContext, String url, String tag,
			final Map<String, String> params, VolleyInterface volleyInterface) {

		MyApplication.getHttpQueues().cancelAll(tag);

		stringRequest = new StringRequest(Method.POST, url,
				volleyInterface.loadingListerner(),
				volleyInterface.errorListener()) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return params;
			}
		};
		
		stringRequest.setTag(tag);
		MyApplication.getHttpQueues().add(stringRequest);
		MyApplication.getHttpQueues().start();

	}
}
