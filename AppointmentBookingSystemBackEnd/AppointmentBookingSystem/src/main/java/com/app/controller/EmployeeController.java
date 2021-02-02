package com.app.controller;


import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Customer;
import com.app.pojos.Employee;
import com.app.repository.EmployeeRepository;
import com.app.service.IEmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService emp_Srv;
	
	@Autowired
	private EmployeeRepository emp_Repo;
	

	
	
	@GetMapping
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> spclztns = emp_Repo.findAll();
	   return ResponseEntity.ok(spclztns);
	}
	
	@PostMapping("/add")
	  public Employee addEmployee(@RequestBody Employee emp) throws Exception
	  {
		  String tempemail = emp.getEmail();
	      String temppassword = emp.getPassword();
		  Employee obj=null;
           if(tempemail!=null && !"".equals(tempemail))
			  {
				  obj=emp_Srv.fetchByEmployeeEmailAndPassword(tempemail,temppassword);
				  if(obj!=null) 
				  {
					  throw new Exception("User with this"+tempemail+" id already exist !");
				  }
			  }
		  
		  return emp_Repo.save(emp);
		  
	  }
	
	@PostMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Employee emp)
	{
		
		Employee newemployee=emp_Repo.save(emp);
		return new ResponseEntity<>(newemployee,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<Employee> optional = emp_Repo.findById(id);
		if (optional.isPresent()) {
			emp_Repo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<Employee> optional = emp_Repo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Employee> loginEmployee(@RequestBody Employee emp) throws Exception
    {
        String tempemail = emp.getEmail();
        String temppassword = emp.getPassword();
        Employee obj=null;
        if(tempemail != null && temppassword != null)
        {
            obj = emp_Srv.fetchByEmployeeEmailAndPassword(tempemail,temppassword);
        }
        if(obj == null)
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<Employee>(obj ,HttpStatus.OK);
        
    }

}
