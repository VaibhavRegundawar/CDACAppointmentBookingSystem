package com.app.controller;

import java.util.List;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Appointment;
import com.app.repository.AppointmentRepository;

@RestController
@RequestMapping("/appointments")
@CrossOrigin("http://localhost:4200")
public class AppointmentController
{
	@Autowired
	private AppointmentRepository apt_Repo;
	
	
	@GetMapping
	public ResponseEntity<?> getAllAppointments() {
		List<Appointment> spclztns = apt_Repo.findAll();
        return ResponseEntity.ok(spclztns);
	}
	
	@PostMapping
	public ResponseEntity<?> addAppointment(@RequestBody Appointment a) {
		System.out.println("in add " + a);
		return new ResponseEntity<>(apt_Repo.save(a), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAppointment(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<Appointment> optional = apt_Repo.findById(id);
		if (optional.isPresent()) {
			apt_Repo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getAppointmentById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<Appointment> optional = apt_Repo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	
}
