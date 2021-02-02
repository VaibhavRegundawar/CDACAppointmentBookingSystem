package com.app.custom_excs;

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception {
	public ResourceNotFoundException(String mesg) {
		super(mesg);
	}
}
