package com.example.volleydemo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application 
{
	
	//全局请求队列
	public static RequestQueue queues;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		//初始化
		queues = Volley.newRequestQueue(getApplicationContext());				
	}
	
	public static RequestQueue getHttpQueues()
	{
		return queues;
	}

}
