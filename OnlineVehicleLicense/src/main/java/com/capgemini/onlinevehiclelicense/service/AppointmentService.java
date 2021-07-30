package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.repository.IAppointmentRepository;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepository;
	
	@Override
	public ResponseEntity<Appointment> createAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		Optional<Appointment> findAppointment = this.appointmentRepository.findById(appointment.getAppointmentNumber());
		try {
			if(!findAppointment.isPresent()) {
				this.appointmentRepository.save(appointment);
				return new ResponseEntity<Appointment>(HttpStatus.CREATED);
			}
			else {
				throw new RecordAlreadyPresentException("Appointment Already Present!!!");
			}
		} catch(RecordAlreadyPresentException e) {
			e.printStackTrace();
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Appointment viewAppointmentDetails(String appointmentNumber) {
		// TODO Auto-generated method stub
		try {
			return this.appointmentRepository.findById(appointmentNumber)
					.orElseThrow(() -> new RecordNotFoundException("No such appointments found!!!"));
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<Appointment> updateAppointment(Appointment appointment) {
		// TODO Auto-generated method stub
		try {
			Appointment findAppointment = this.appointmentRepository.findById(appointment.getAppointmentNumber())
					.orElseThrow(() -> new RecordNotFoundException("Appointment does not exist!!!"));
			findAppointment.setTestDate(appointment.getTestDate());
			findAppointment.setTimeSlot(appointment.getTimeSlot());
			this.appointmentRepository.save(findAppointment);
			return new ResponseEntity<Appointment>(HttpStatus.OK);
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<Appointment> deleteAppointment(String appointmentNumber) {
		// TODO Auto-generated method stub
		try {
			Appointment findAppointment = this.appointmentRepository.findById(appointmentNumber)
					.orElseThrow(() -> new RecordNotFoundException("Appointment does not exist!!!"));
			this.appointmentRepository.delete(findAppointment);
			return new ResponseEntity<Appointment>(HttpStatus.OK);
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<Appointment>(HttpStatus.NOT_FOUND);
		}
	}

}
