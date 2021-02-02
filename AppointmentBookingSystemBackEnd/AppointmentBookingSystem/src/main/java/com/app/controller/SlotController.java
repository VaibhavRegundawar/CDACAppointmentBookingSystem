package com.app.controller;
import java.time.LocalDate;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.custom_excs.ResourceNotFoundException;
import com.app.dto.ErrorResponse;
import com.app.dto.ResponseDTO;
import com.app.pojos.Slot;
import com.app.pojos.Status;
import com.app.repository.SlotRepository;
import com.app.service.ISlotService;

@RestController
@RequestMapping("/slots")
@CrossOrigin("http://localhost:4200")
public class SlotController {

	@Autowired
	private SlotRepository slotRepo;
	
	@Autowired
	private ISlotService slotSrv;
	
	@GetMapping
	public ResponseEntity<?> getAllSlots() {
		List<Slot> spclztns = slotRepo.findAll();
		return ResponseEntity.ok(spclztns);
	}

	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteSlot(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<Slot> optional = slotRepo.findById(id);
		if (optional.isPresent()) {
			slotRepo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getSlotById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<Slot> optional = slotRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> addSlot(@RequestBody Slot s) {
		System.out.println("in add " + s);
		return new ResponseEntity<>(slotRepo.save(s), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/date/{slotDate}")
	public ResponseEntity<?> getSlotDetailsByDate(@PathVariable String slotDate) {
		System.out.println("in get emp dtls " + slotDate);
		
		Slot s= new Slot();
		Enum<Status> sp=s.getSlotstatus().AVAILABLE;
	
		List<Slot> optional = slotRepo.getSlotByDate(LocalDate.parse(slotDate),sp);
				
		if (optional == null)
			
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(optional, HttpStatus.OK);
			}
	
	@PutMapping("/{slotID}")
	public ResponseEntity<?> updateSlotDetails(@PathVariable int slotID, @RequestBody Slot s) throws ResourceNotFoundException {
		System.out.println("in update slot " + slotID + " " + s);
		
		Optional<Slot> optional = slotRepo.findById(slotID);
		if (optional.isPresent()) {
			
			Slot existingSlot = optional.get();// DETACHED
			System.out.println("existing emp " + existingSlot);
			existingSlot.setSlotstatus(s.getSlotstatus());
			
            return new ResponseEntity<>(slotRepo.save(existingSlot), HttpStatus.OK);
			
		} else
			throw new ResourceNotFoundException("Slot ID Invalid");

	}
}
