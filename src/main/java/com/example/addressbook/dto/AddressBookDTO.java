package com.example.addressbook.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Data
public class AddressBookDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Invalid Name")
	public String name;
	@NotEmpty
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
