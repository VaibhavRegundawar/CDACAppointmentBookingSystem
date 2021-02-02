package com.app.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.pojos.Slot;
import com.app.pojos.Status;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Integer> {

	@Query("select t from Slot t where t.date=:sdate and t.slotstatus=:status")
	List<Slot> getSlotByDate(LocalDate sdate, Enum<Status> status);
}
