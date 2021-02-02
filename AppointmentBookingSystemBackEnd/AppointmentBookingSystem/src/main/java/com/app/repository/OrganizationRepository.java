package com.app.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.pojos.Organization;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {

	Optional<Organization> findByEmail(String email);
	
	@Query(value = "select * from organizations",nativeQuery =true) 
	List<Organization> getAllOrganizations();
	
	/*@Query(value = "select * from organizations",nativeQuery =true) 
	ArrayList<Organization> getAllOrganizations();*/
	
	Organization findByEmailAndPassword(String tempemail, String temppassword);
	
	

}
