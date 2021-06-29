package com.example.addressbook.services;

import java.util.List;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;

public interface IAddressBookService {
	List<AddressBookData> getAddressBookData();
	List<AddressBookData> getContactDetailsByName(String name);
	AddressBookData getAddressBookDataById(int addId);
	AddressBookData createAddressBookData(AddressBookDTO addressBookDTO);
	AddressBookData updateAddressBookData(int addId, AddressBookDTO addressBookDTO);
	void deleteAddressBookData(int addId);

}
