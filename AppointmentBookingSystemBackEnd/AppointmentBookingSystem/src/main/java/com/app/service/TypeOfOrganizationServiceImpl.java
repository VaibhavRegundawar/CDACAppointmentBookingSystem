package com.app.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.pojos.TypeOfOrganization;
import com.app.repository.TypeOfOrganiationRepository;

@Service
@Transactional
public class TypeOfOrganizationServiceImpl implements ITypeOfOrganizationService {

	@Autowired
	private TypeOfOrganiationRepository typeRepo;

	@Override
	public List<TypeOfOrganization> getAllTypeOfOrganizations() {
		return typeRepo.findAll();
		
	}
	
	
	
}
