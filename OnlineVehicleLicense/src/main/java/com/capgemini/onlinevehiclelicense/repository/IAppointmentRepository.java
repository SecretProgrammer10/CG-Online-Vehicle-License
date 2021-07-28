package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Appointment;

@Repository
public interface IAppointmentRepository extends JpaRepository< Appointment, String> {

}
