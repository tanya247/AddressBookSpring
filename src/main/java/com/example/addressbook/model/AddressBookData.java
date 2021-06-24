package com.example.addressbook.model;

import com.example.addressbook.dto.AddressBookDTO;

import lombok.Data;

@Data
public class AddressBookData {
	private int addressBookId;
	private String name;
	private String address;
		
	public AddressBookData() {
		
	}

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		super();
		this.addressBookId = addressBookId;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
	}






}
