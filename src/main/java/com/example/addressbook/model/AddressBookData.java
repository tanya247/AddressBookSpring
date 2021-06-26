package com.example.addressbook.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.addressbook.dto.AddressBookDTO;

import lombok.Data;

@Entity
@Table(name="AddressBookEntries")
@Data
public class AddressBookData {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Id")
	private int addressBookId;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Address")
	private String address;
	
	@Column(name = "State")
	private String state;
	
	@Column(name = "City")
	private String city;
	
	@Column(name = "Zip")
	private String zip;
	
	@Column(name = "PhoneNo")
	private String PhoneNo;
	
	public AddressBookData() {
		
	}

	public AddressBookData(int addressBookId, AddressBookDTO addressBookDTO) {
		super();
		this.addressBookId = addressBookId;
		this.name = addressBookDTO.name;
		this.address = addressBookDTO.address;
		this.state = addressBookDTO.state;
		this.city = addressBookDTO.city;
		this.zip = addressBookDTO.zip;
		this.PhoneNo = addressBookDTO.PhoneNo;
	}
	
}
