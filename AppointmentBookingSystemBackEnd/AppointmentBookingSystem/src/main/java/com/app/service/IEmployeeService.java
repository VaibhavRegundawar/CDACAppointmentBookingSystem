package com.app.service;

import com.app.pojos.Employee;

public interface IEmployeeService {

	public Employee fetchByEmployeeEmailAndPassword(String tempemail, String temppassword);
}
