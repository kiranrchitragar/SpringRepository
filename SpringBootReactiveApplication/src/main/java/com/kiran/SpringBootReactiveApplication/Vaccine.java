package com.kiran.SpringBootReactiveApplication;

public class Vaccine {
	private String name;
	private boolean delivered;
	
	
	public Vaccine(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isDelivered() {
		return delivered;
	}
	public void setDelivered(boolean delivered) {
		this.delivered = delivered;
	}
	
	
	
}
