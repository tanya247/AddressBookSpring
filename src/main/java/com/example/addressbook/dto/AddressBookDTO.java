package com.example.addressbook.dto;

import lombok.Data;

@Data
public class AddressBookDTO {
	public String name;
	public String address;
	
	
	public AddressBookDTO() {
		super();
	}
	public AddressBookDTO(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

}
