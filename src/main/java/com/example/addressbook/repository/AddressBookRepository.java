package com.example.addressbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.addressbook.model.AddressBookData;

public interface AddressBookRepository extends JpaRepository<AddressBookData,Integer> {
	@Query(value = "Select * from address_book_entries where name LIKE %:name%", nativeQuery=true)
	List<AddressBookData> findContactDetails(@Param("name") String name);

}
