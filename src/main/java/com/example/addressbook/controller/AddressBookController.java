package com.example.addressbook.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.model.AddressBookData;
import com.example.addressbook.services.IAddressBookService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/addressbook")
@Slf4j
public class AddressBookController {
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@GetMapping(value = {"","/","/get"})
	public ResponseEntity<ResponseDTO> getAddressBookData(){
		List<AddressBookData> addressBookData = addressBookService.getAddressBookData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}

	@GetMapping("/get/{addId}")
	public ResponseEntity<ResponseDTO> getAddressBookData(@PathVariable("addId") int addId){
		AddressBookData addressBookData = addressBookService.getAddressBookDataById(addId);
		ResponseDTO respDTO = new ResponseDTO("Get Call Success", addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	@GetMapping("/name/{name}")
	public ResponseEntity<ResponseDTO>findByName(@PathVariable("name") String name){
		List<AddressBookData> addressBookData = addressBookService.getContactDetailsByName(name);
		ResponseDTO responseDto = new ResponseDTO("The Contact Details are", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
	}
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addAddressBookData(@Valid @RequestBody AddressBookDTO addressBookDTO){
		log.debug("Address Book Dto: "+addressBookDTO.toString());
		AddressBookData addressBookData = addressBookService.createAddressBookData(addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create AddressBOOK Data Successfull", addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@PutMapping("/update/{addId}")
	public ResponseEntity<ResponseDTO> updateAddressBookData(@PathVariable("addId") int addId,@Valid @RequestBody AddressBookDTO addressBookDTO){
		AddressBookData addressBookData = addressBookService.updateAddressBookData(addId, addressBookDTO);
		ResponseDTO respDTO = new ResponseDTO("Create AddressBOOK Data Successfull", addressBookData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{addId}")
	public ResponseEntity<ResponseDTO> deleteAddressBookData(@PathVariable("addId") int addId){
		addressBookService.deleteAddressBookData(addId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfull", "Deleted id "+addId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
}
