package com.wuhanbus.entity;

public abstract class Card {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public abstract String pay();
}
