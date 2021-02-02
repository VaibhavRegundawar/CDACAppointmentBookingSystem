package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Customer;
import com.app.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository cst_Repo;
	
	@Override
     public Customer fetchByCustomerEmailAndPassword(String tempemail, String temppassword) {
			 return cst_Repo.findByEmailAndPassword(tempemail,temppassword);
	}
	
	public Customer RegisterCustomer(Customer customer) 
	{
		return cst_Repo.save(customer);
	}
		
	

	
}
