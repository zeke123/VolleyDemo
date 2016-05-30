package com.example.volleydemo.bean;

import java.io.Serializable;


public class Profile implements Serializable {

  
	

	private static final long serialVersionUID = 6205005949562112660L;
	
	private long birthday;
    private String armymantransferred;
    private String phone;
    private String address;
    private String headimg;
    private String name;
    private int worklife;
    private String province;
    private String gender;
    private String district;
    private String city;

    public long getBirthday() {
        return birthday;
    }

    public void setBirthday(long birthday) {
        this.birthday = birthday;
    }

    public String getArmymantransferred() {
        return armymantransferred;
    }

    public void setArmymantransferred(String armymantransferred) {
        this.armymantransferred = armymantransferred;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWorklife() {
        return worklife;
    }

    public void setWorklife(int worklife) {
        this.worklife = worklife;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "birthday=" + birthday +
                ", armymantransferred='" + armymantransferred + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", headimg='" + headimg + '\'' +
                ", name='" + name + '\'' +
                ", worklife=" + worklife +
                ", province='" + province + '\'' +
                ", gender='" + gender + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
