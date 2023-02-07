package com.kiran.requestResponse;

import com.kiran.entity.Address;

public class AddressResponse {

	
	
	public AddressResponse(Address address) {
		this.addressId = address.getId();;
		this.street = address.getStreet();
		this.city = address.getCity();
	}
	private Long addressId;
	private String street;
	private String city;
	
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}

