package com.example.volleydemo.bean;

import java.io.Serializable;

public class UserData implements Serializable{

	
	private static final long serialVersionUID = -5626522787801344975L;

	private AppUser appuser;

	private Profile profile;

	public AppUser getAppuser() {
		return appuser;
	}

	public void setAppuser(AppUser appuser) {
		this.appuser = appuser;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "UserData [appuser=" + appuser + ", profile=" + profile + "]";
	}
	
	


}
