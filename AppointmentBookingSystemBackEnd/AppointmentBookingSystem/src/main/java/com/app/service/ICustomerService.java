package com.app.service;

import com.app.pojos.Customer;

public interface ICustomerService {

	public Customer fetchByCustomerEmailAndPassword(String tempemail, String temppassword);
	
	public Customer RegisterCustomer(Customer customer); 
}
