package com.app.controller;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Service;
import com.app.repository.ServiceRepository;
import com.app.service.IServiceService;

@RestController
@RequestMapping("/services")
@CrossOrigin("http://localhost:4200")
public class ServiceController {

	@Autowired
    private ServiceRepository servRepo;
	
	@Autowired
	private IServiceService servSrv; 
	
	@GetMapping
	public ResponseEntity<?> listAllService() {
		System.out.println("in list all products");
		
		List<Service> list=servSrv.getAllServices();
		if (list.isEmpty())
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping("add")
	public ResponseEntity<?> addService(@RequestBody Service s) {
		System.out.println("in add " + s);
		return new ResponseEntity<>(servRepo.save(s), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteService(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<Service> optional = servRepo.findById(id);
		if (optional.isPresent()) {
			servRepo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getServiceById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<Service> optional = servRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	

}
