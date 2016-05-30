package com.example.volleydemo;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.android.volley.Request.Method;
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.example.volleydemo.bean.AppUser;
import com.example.volleydemo.bean.Profile;
import com.example.volleydemo.bean.UserData;
import com.example.volleydemo.bean.UserLoginData;
import com.google.gson.Gson;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

/**
 * 
 * @author 周建 2016-05-27
 * 
 *         Volley 的特点:
 * 
 *         第一，通信更快，更简单 第二，Get，Post请求及网络图像的高效率异步处理请求 第三，排序 第四，网络请求缓存 第五，多级别取消请求
 *         第六，和Activity的生命周期联动
 * 
 *         StringRequest(不确定返回数据类型时候使用) JsonObjectRequest(返回的是JsonObject)
 *         JsonArrayRequest(返回的是JsonArray)
 * 
 */

public class MainActivity extends Activity {

	private static final String TAG = "Volley";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// volleyGetStringRequest();
		// volleyGetJsonObjectRequest();
		// volleyPostStringRequest();
		// volleyPostJsonObjectRequest();
		// 二次封装
		//myVolleyGet();
		
		//myVolleyPost();
		
		
		
		findViewById(R.id.bt_button).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
		myVolleyPost2();
			
			
			}
		});
		


	}

	protected void myVolleyPost2()
	{

		HashMap<String, String> params = new HashMap<String, String>();
		
		params.put("username", "13522890123");
	
		//63b6af906ec44318838db1154e124355
		
		
		VolleyRequest.requestPost(getApplicationContext(),
				"http://abbapi.17yun.com.cn/app/user/checkphone", "my22", params, new VolleyInterface(
						MainActivity.this, VolleyInterface.mListener,
						VolleyInterface.mErrorListener) {

					@Override
					public void onMySuccess(String resault)
					
					{		
						
						Toast.makeText(getApplicationContext(),resault.toString(), Toast.LENGTH_SHORT).show();
						
						Log.e(TAG, "resault============"+resault.toString());
					
						
						
					}

					@Override
					public void onMyError(VolleyError error) {
						Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
					}
				});
	}

	private void myVolleyPost() {

		HashMap<String, String> params = new HashMap<String, String>();
		
		
		params.put("username", "13522890123");
		params.put("pwd", MD5.getMessageDigest("123456"));

		VolleyRequest.requestPost(getApplicationContext(),
				"http://abbapi.17yun.com.cn/app/user/login", "myTag", params, new VolleyInterface(
						MainActivity.this, VolleyInterface.mListener,
						VolleyInterface.mErrorListener) {

				

					@Override
					public void onMySuccess(String resault)
					{						
						Gson gson = new Gson();						
						UserLoginData UserLoginData = gson.fromJson(resault.toString(), UserLoginData.class);						
						UserData userData = UserLoginData.getData();						
						AppUser appuser = userData.getAppuser();						
						Profile profile = userData.getProfile();
						
				
						
						//myVolleyPost2(token);
						
						
						//Log.e(TAG, "appuser=="+appuser.toString());
						Toast.makeText(getApplicationContext(),resault.toString(), Toast.LENGTH_SHORT).show();				
					}

					@Override
					public void onMyError(VolleyError error) {
						Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
					}
				});
	}

	private void myVolleyGet() {
		VolleyRequest.requestGet(getApplicationContext(),
				"http://www.baidu.com", "myTag", new VolleyInterface(
						MainActivity.this, VolleyInterface.mListener,
						VolleyInterface.mErrorListener) {

					@Override
					public void onMySuccess(String resault) {
						Toast.makeText(getApplicationContext(),
								resault.toString(), Toast.LENGTH_SHORT).show();

					}

					@Override
					public void onMyError(VolleyError error) {

					}
				});
	}

	private void volleyPostJsonObjectRequest() {

		HashMap<String, String> params = new HashMap<String, String>();
		
		
		params.put("profileid", "1");
		params.put("role", "102001");
		params.put("pageno", "1");
		params.put("pagesize", "10");
		params.put("token", "63b6af906ec44318838db1154e124355");
		
		
		

		JSONObject jsonObject = new JSONObject(params);

		JsonObjectRequest jsonObjectRequestPost = new JsonObjectRequest(
				Method.POST, "http://abbapi.17yun.com.cn/app/project/projectlist", jsonObject,
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						
						Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_SHORT).show();	
						
						

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						
						Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();	

					}
				});

		jsonObjectRequestPost.setTag("MainActivityTagFour");
		MyApplication.getHttpQueues().add(jsonObjectRequestPost);

	}

	private void volleyPostStringRequest() {

		StringRequest stringRequestPost = new StringRequest(Method.POST,
				"http://abbapi.17yun.com.cn/app/project/projectlist", new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {

						Log.e(TAG, "response==" + response.toString());

						Toast.makeText(getApplicationContext(),
								response.toString(), Toast.LENGTH_SHORT).show();

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

						Log.e(TAG, "error==" + error.toString());

					}
				}) {
			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				HashMap<String, String> params = new HashMap<String, String>();
				params.put("profileid", "1");
				params.put("role", "102001");
				params.put("pageno", "1");
				params.put("pagesize", "10");
				params.put("token", "63b6af906ec44318838db1154e124355");
				
				return params;
			}
		};
		stringRequestPost.setTag("MainActivityTagThree");
		MyApplication.getHttpQueues().add(stringRequestPost);

	}

	// 无参数 get
	private void volleyGetJsonObjectRequest() {
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Method.GET,
				"http://www.baidu.com", null,
				new Response.Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject jsonObject) {
						Toast.makeText(getApplicationContext(),
								jsonObject.toString(), Toast.LENGTH_SHORT)
								.show();

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						Toast.makeText(getApplicationContext(),
								error.toString(), Toast.LENGTH_SHORT).show();

					}
				});
		jsonObjectRequest.setTag("MainActivityTagTwo");
		MyApplication.getHttpQueues().add(jsonObjectRequest);

	}

	private void volleyGetStringRequest() {

		StringRequest stringRequestGet = new StringRequest(Method.GET,
				"http://www.baidu.com", new Response.Listener<String>() {

					@Override
					public void onResponse(String response) {

						Log.e(TAG, "response==" + response.toString());

						Toast.makeText(getApplicationContext(),
								response.toString(), Toast.LENGTH_SHORT).show();

					}
				}, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

						Log.e(TAG, "error==" + error.toString());

					}
				});
		stringRequestGet.setTag("MainActivityTagOne");
		MyApplication.getHttpQueues().add(stringRequestGet);

	}

	@Override
	protected void onStop() {
		super.onStop();

		MyApplication.getHttpQueues().cancelAll("myTag");
		MyApplication.getHttpQueues().cancelAll("MainActivityTagTwo");
		MyApplication.getHttpQueues().cancelAll("MainActivityTagThree");
		MyApplication.getHttpQueues().cancelAll("MainActivityTagFour");
	}
}
