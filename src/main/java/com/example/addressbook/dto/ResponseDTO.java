package com.example.addressbook.dto;

import lombok.Data;

@Data
public class ResponseDTO {
	private String message;
	private Object data;
	
	public ResponseDTO() {
		
	}
	
	public ResponseDTO(String message, Object data) {
		super();
		this.message = message;
		this.data = data;
	}
	



}
