package com.example.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.addressbook.exception.*;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;

@Service
public class AddressBookService implements IAddressBookService {
	
	private List<AddressBookData> addressBookDataList = new ArrayList<>();
	
	@Override
	public List<AddressBookData> getAddressBookData(){
		return addressBookDataList;
	}

	@Override
	public AddressBookData getAddressBookDataById(int addId) {
		return addressBookDataList.stream()
								   .filter(addressData -> addressData.getAddressBookId() == addId)
								   .findFirst()
								   .orElseThrow(() -> new AddressBookException("Contact not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(addressBookDataList.size()+1, addressBookDTO);
		addressBookDataList.add(addressBookData);
		return addressBookData;
	}

	@Override
	public AddressBookData updateAddressBookData(int addId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(addId);
		addressBookData.setName(addressBookDTO.name);
		addressBookData.setAddress(addressBookDTO.address);
		addressBookDataList.set(addId-1, addressBookData);
		return addressBookData;
	}

	@Override
	public void deleteAddressBookData(int addId) {
		AddressBookData addressBookData = addressBookDataList.stream()
				   											 .filter(addressData -> addressData.getAddressBookId() == addId)
				   											 .findFirst()
				   											 .orElseThrow(() -> new AddressBookException("Delete cann't be successfull because id is incorrect"));;
		int m = addressBookDataList.indexOf(addressBookData);
		addressBookDataList.remove(m);

}
				   
		
	

}
