package com.app.service;
import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import com.app.pojos.Organization;
public interface IOrganizationService {

	List<Organization> getAllOrganization();
	
	Optional<Organization> getOrgByEmailId(String email);
	Organization RegisterOrganization(Organization org);
	
	public Organization fetchByOrganizationEmailAndPassword(String tempemail, String temppassword);
	
	
}
