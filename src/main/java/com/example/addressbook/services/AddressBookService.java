package com.example.addressbook.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.addressbook.exception.*;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.repository.AddressBookRepository;


@Service
public class AddressBookService implements IAddressBookService {
	
	private List<AddressBookData> addressBookDataList = new ArrayList<>();
	
	@Autowired
	private AddressBookRepository addressBookRepository;
	
	@Override
	public List<AddressBookData> getAddressBookData(){
		return addressBookRepository.findAll();
	}
	
	@Override
	public AddressBookData getAddressBookDataById(int addId) {
		return addressBookRepository.findById(addId)
								   .orElseThrow(() -> new AddressBookException("Contact not found"));
	}

	@Override
	public AddressBookData createAddressBookData(AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = new AddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public AddressBookData updateAddressBookData(int addId, AddressBookDTO addressBookDTO) {
		AddressBookData addressBookData = this.getAddressBookDataById(addId);
		addressBookData.updateAddressBookData(addressBookDTO);
		return addressBookRepository.save(addressBookData);
	}

	@Override
	public void deleteAddressBookData(int addId) {
		AddressBookData addressBookData = addressBookRepository
				.findById( addId)
				.orElseThrow(() -> new AddressBookException("Delete cannot be succesfull !! Invalid ID"));
	    addressBookRepository.delete(addressBookData);
	}

	@Override
	public List<AddressBookData> getContactDetailsByName(String name) {
		return addressBookRepository.findContactDetails(name);
	}


}
				   
		
	


