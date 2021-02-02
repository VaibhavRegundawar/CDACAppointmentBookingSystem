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
import com.app.repository.CustomerRepository;
import com.app.service.ICustomerService;


@RestController
@RequestMapping("/customers")
@CrossOrigin("http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerRepository cst_Repo;
	
	@Autowired
	private ICustomerService cst_Srv;
	
	@GetMapping
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> spclztns = cst_Repo.findAll();
		return ResponseEntity.ok(spclztns);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<Customer> optional = cst_Repo.findById(id);
		if (optional.isPresent()) {
			cst_Repo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<Customer> optional = cst_Repo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	
	@PostMapping("/login")
	public ResponseEntity<Customer> loginCustomer(@RequestBody Customer cst) throws Exception
    {
        String tempemail = cst.getEmail();
        String temppassword = cst.getPassword();
        Customer obj=null;
        if(tempemail != null && temppassword != null)
        {
            obj = cst_Srv.fetchByCustomerEmailAndPassword(tempemail,temppassword);
        }
        if(obj == null)
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<Customer>(obj ,HttpStatus.OK);
        
    }
	
	@PostMapping("/register")
	  public Customer Register(@RequestBody Customer customer) throws Exception
	  {
		  String tempemail = customer.getEmail();
	      String temppassword = customer.getPassword();
		  Customer obj=null;

		  
			if(tempemail!=null && !"".equals(tempemail))
			  {
				  obj=cst_Srv.fetchByCustomerEmailAndPassword(tempemail,temppassword);
				  if(obj!=null) 
				  {
					  throw new Exception("User with this"+tempemail+" id already exist !");
				  }
			  }
		  
		  return cst_Srv.RegisterCustomer(customer);
		  
	  }
	
	@PostMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer cust)
	{
		
		Customer newemployee=cst_Repo.save(cust);
		return new ResponseEntity<>(newemployee,HttpStatus.OK);
	}

	
	
}
