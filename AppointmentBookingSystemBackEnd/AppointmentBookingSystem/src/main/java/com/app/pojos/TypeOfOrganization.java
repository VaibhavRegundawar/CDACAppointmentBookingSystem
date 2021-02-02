package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.*;


@Entity
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Table(name="type_of_organizations")
public class TypeOfOrganization {
	
	@Id
	@Column(name="org_type_id",unique=true)
	private Integer orgTypeId;
	
    @Column(name="org_type",nullable = false,length=30,unique=true)
	private String orgType;

   @JsonIgnore
    @OneToMany(mappedBy = "belongsToOrgType",cascade = CascadeType.ALL)
    private List<Organization> organizations=new ArrayList<>();

   @JsonIgnore
	@OneToMany(mappedBy = "appointmentOfOrgType",cascade=CascadeType.ALL)
	private List<Appointment> appointments =new ArrayList<>();
    
	public TypeOfOrganization() {
		super();
	}

	public TypeOfOrganization(Integer id, String orgType) {
		super();
		this.orgTypeId = id;
		this.orgType = orgType;
	}

	

	public Integer getOrgTypeId() {
		return orgTypeId;
	}

	public void setOrgTypeId(Integer orgTypeId) {
		this.orgTypeId = orgTypeId;
	}

	public String getOrgType() {
		return orgType;
	}

	public void setOrgType(String orgType) {
		this.orgType = orgType;
	}

	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	public List<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		return "TypeOfOrganization [id=" + orgTypeId + ", orgType=" + orgType + "]";
	}

	
}
