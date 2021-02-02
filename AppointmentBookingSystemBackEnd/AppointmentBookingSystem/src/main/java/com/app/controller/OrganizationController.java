package com.app.controller;

import java.io.IOException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ErrorResponse;
import com.app.dto.ImageDTO;
import com.app.dto.ResponseDTO;
import com.app.pojos.Customer;
import com.app.pojos.Organization;
import com.app.pojos.TypeOfOrganization;
import com.app.repository.OrganizationRepository;
import com.app.service.IOrganizationService;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/organizations")
@CrossOrigin("http://localhost:4200")
public class OrganizationController {

	@Autowired
    private IOrganizationService orgSrv;
	
	@Autowired
	private OrganizationRepository orgRepo;
	
	@GetMapping
	public ResponseEntity<?> getAllOrganizations() {
		List<Organization> spclztns = orgSrv.getAllOrganization();
	
		return ResponseEntity.ok(spclztns);
	}
	     

	@PostMapping("/update")
	public ResponseEntity<?> updateOrganization(@RequestBody Organization o) {
		System.out.println(o.getBelongsToOrgType().getOrgTypeId());
		return new ResponseEntity<>(orgRepo.save(o), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteOrganization(@PathVariable Integer id) {
		System.out.println("in delete emp " + id);
		Optional<Organization> optional = orgRepo.findById(id);
		if (optional.isPresent()) {
			orgRepo.deleteById(id);
			return new ResponseEntity<>(new ResponseDTO("Emp rec deleted with ID " + id), HttpStatus.OK);
		}
		return null;}
			
		
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrganizationById(@PathVariable Integer id) {
		System.out.println("in get  dtls " + id);
		Optional<Organization> optional = orgRepo.findById(id);
		if (optional.isPresent())
			return ResponseEntity.ok(optional.get());
		ErrorResponse resp = new ErrorResponse(" Id Invalid", "Must Supply valid  Id");
		return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
	}
	
	

	@PostMapping("/login")
	public ResponseEntity<Organization> loginOrganization(@RequestBody Organization org) throws Exception
    {
        String tempemail = org.getEmail();
        String temppassword = org.getPassword();
        Organization obj=null;
        if(tempemail != null && temppassword != null)
        {
            obj = orgSrv.fetchByOrganizationEmailAndPassword(tempemail,temppassword);
        }
        if(obj == null)
        {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return new ResponseEntity<Organization>(obj ,HttpStatus.OK);
        
    }
	
	@PostMapping("/register")
	public ResponseDTO RegisterOrganization(@RequestParam String dtls, @RequestParam MultipartFile imageFile,@RequestParam String TypeOfOrg) {
		try {
			
			Organization org= new ObjectMapper().readValue(dtls, Organization.class);
			TypeOfOrganization type= new ObjectMapper().readValue(TypeOfOrg, TypeOfOrganization.class);
			org.setOrg_img(imageFile.getBytes());
			org.setImageContentType(imageFile.getContentType());
			org.setBelongsToOrgType(type);
			
			orgRepo.save(org);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResponseDTO("File uploaded :" + imageFile.getOriginalFilename() + " @ ", LocalDateTime.now());
	}

	
	@GetMapping("/download/{orgId}")
	public ResponseEntity<?> downloadImage(@PathVariable int orgId) throws IOException {
		//System.out.("in img download " + userId);
		Organization org = orgRepo.findById(orgId).get();
//		Path path = Paths.get(location, imgName);
		ImageDTO img = new ImageDTO();
		// img.setName(imgName);
		img.setData(org.getOrg_img());
		img.setType(org.getImageContentType());
//		System.out.println(img.getType());

		return new ResponseEntity<>(img, HttpStatus.OK);

	}


	
}
