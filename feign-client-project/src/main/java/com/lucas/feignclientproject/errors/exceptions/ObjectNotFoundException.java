package com.lucas.feignclientproject.errors.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	public ObjectNotFoundException(String msg){
		super(msg);
	}

}