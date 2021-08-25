package com.capgemini.onlinevehiclelicense.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository< Appointment, String> {

	@Query("select a from Appointment a where a.rtoOffice.rtoId like ?1")
	Set<Appointment> getAppointments(int rtoId);

}
