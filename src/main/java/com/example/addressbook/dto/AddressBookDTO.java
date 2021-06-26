package com.example.addressbook.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;
import lombok.ToString;

@Data
public @ToString class AddressBookDTO {
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="Invalid Name")
	public String name;
	@NotBlank(message = "Address must not be Empty")
	public String address;
	@NotBlank(message = "State must not be Empty")
	public String state;
	@NotBlank(message = "City must not be Empty")
	public String city;
	@Pattern(regexp = "^[0-9]{6}$",message ="Invalid Zip")
	public String zip;
	@Pattern(regexp = "[0-9]{10}",message ="Invalid Phone No")
	public String PhoneNo;
	
	public AddressBookDTO() {
		super();
	}

	public AddressBookDTO(String name, String address, String state, String city, String zip,String phoneNo) {
		super();
		this.name = name;
		this.address = address;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.PhoneNo = phoneNo;
	}

}
