package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.pojos.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {

}
