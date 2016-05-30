package com.example.volleydemo.bean;

import java.io.Serializable;

public class UserLoginData implements Serializable
{
	
	
	private static final long serialVersionUID = -8080102650310450718L;
	private String status;
	private UserData data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UserData getData() {
		return data;
	}
	public void setData(UserData data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "UserLoginData [status=" + status + ", data=" + data + "]";
	}
}
