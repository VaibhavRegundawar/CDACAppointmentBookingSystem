package com.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.Organization;
import com.app.repository.OrganizationRepository;


@Service
@Transactional
public class OrganizationServiceImpl implements IOrganizationService {

	@Autowired
	private OrganizationRepository org_Repo;
	
	
	@Override
	public List<Organization> getAllOrganization() {
		
		return org_Repo.getAllOrganizations();
	}
	
	
	/*@Override
	public ArrayList<Organization> getAllOrganization() {
		
		return org_Repo.getAllOrganizations();
	}
	*/
	
	@Override
	public Optional<Organization> getOrgByEmailId(String email) {
		
		return org_Repo.findByEmail(email);
	}
	
	@Override
	public Organization RegisterOrganization(Organization org) {
		
	     return  org_Repo.save(org);
	}

	@Override
	public Organization fetchByOrganizationEmailAndPassword(String tempemail, String temppassword) {
		
		return org_Repo.findByEmailAndPassword(tempemail,temppassword);
	}

	
}
