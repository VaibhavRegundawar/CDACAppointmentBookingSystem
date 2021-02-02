package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.TypeOfOrganization;

@Repository
public interface TypeOfOrganiationRepository extends JpaRepository<TypeOfOrganization, Integer> {

}
