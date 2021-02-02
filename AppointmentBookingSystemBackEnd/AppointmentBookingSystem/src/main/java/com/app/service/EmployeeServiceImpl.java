package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository emp_Repo;
	
	
	@Override
	public Employee fetchByEmployeeEmailAndPassword(String tempemail, String temppassword) {
		return emp_Repo.findByEmailAndPassword(tempemail,temppassword);
		
	}

	
}
