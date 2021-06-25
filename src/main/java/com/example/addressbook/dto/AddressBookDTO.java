package com.example.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@Data
public @ToString class AddressBookDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Invalid Name")
	public String name;
	@NotEmpty(message = "Address must not be Empty")
	public String address;
	public String state;
	public String city;
	public int zip;
	public long PhoneNo;
	
	public AddressBookDTO() {
		super();
	}

	public AddressBookDTO(String name, String address, String state, String city, int zip,long phoneNo) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
		PhoneNo = phoneNo;
	}

}
