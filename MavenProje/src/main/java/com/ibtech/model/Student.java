package com.ibtech.model;


public class Student{
	private String ad;
	private String soyad;
	private Integer sicilNo;
	private String title;
	private String email;
	
	boolean editable;
	
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public Integer getSicilNo() {
		return sicilNo;
	}
	public void setSicilNo(Integer sicilNo) {
		this.sicilNo = sicilNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
	
	
}