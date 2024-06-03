package com.zettamine.isa.dto;

public enum Status {
	
	
	SCHEDULED("SCHEDULED"),
	COMPLETED("COMPLETED"),
	CANCELED("CANCELED");

	String value;
	Status(String str) {
		this.value =str;
	}
	public  String getValue() {
		return this.value;
	}
}