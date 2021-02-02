package com.app.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.repository.ServiceRepository;
import com.app.pojos.*;
@Service
@Transactional
public class ServiceServiceImpl implements IServiceService {

	@Autowired
	private ServiceRepository serv_Repo;
	@Override
	public List<com.app.pojos.Service> getAllServices() {
		
		return serv_Repo.findAll();
	}
	
	
	
	

}
