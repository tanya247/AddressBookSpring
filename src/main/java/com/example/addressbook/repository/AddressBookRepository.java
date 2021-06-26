package com.example.addressbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Long> {

}
