package com.app.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;

import com.app.pojos.TypeOfOrganization;
import com.app.repository.TypeOfOrganiationRepository;
import com.app.service.ITypeOfOrganizationService;

@RestController
@RequestMapping("/typeOfOrgs")
@CrossOrigin("http://localhost:4200")
public class TypeOfOrganizationController {

	@Autowired
	private ITypeOfOrganizationService typeSrv;
	
	@Autowired
	private TypeOfOrganiationRepository typeRepo;
	
	@GetMapping
	public ResponseEntity<?> listAllTypesOfOrgs() {
		
		List<TypeOfOrganization> list= typeSrv.getAllTypeOfOrganizations();
		if (list.isEmpty())
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	
	

	@PostMapping
	public ResponseEntity<?> addTypeOfOrganization(@RequestBody  TypeOfOrganization e) {
		System.out.println("in add emp " + e);
		return new ResponseEntity<>(typeRepo.save(e), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteTypeOfOrganization(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<TypeOfOrganization> optional = typeRepo.findById(id);
		if (optional.isPresent()) {
			typeRepo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getTypeOfOrganizationById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<TypeOfOrganization> optional = typeRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	
}
