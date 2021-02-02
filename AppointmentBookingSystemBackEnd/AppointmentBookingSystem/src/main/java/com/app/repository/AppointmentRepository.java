package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment,Integer>
{

}
