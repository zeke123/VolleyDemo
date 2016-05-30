package com.example.volleydemo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class MyApplication extends Application 
{
	
	//ȫ���������
	public static RequestQueue queues;
	
	@Override
	public void onCreate() 
	{
		super.onCreate();
		//��ʼ��
		queues = Volley.newRequestQueue(getApplicationContext());				
	}
	
	public static RequestQueue getHttpQueues()
	{
		return queues;
	}

}
