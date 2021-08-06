package com.capgemini.onlinevehiclelicense.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Appointment;
import com.capgemini.onlinevehiclelicense.model.RTOOffice;
import com.capgemini.onlinevehiclelicense.repository.IApplicationRepository;
import com.capgemini.onlinevehiclelicense.repository.IAppointmentRepository;
import com.capgemini.onlinevehiclelicense.repository.IRTOOfficeRepository;
import com.fasterxml.jackson.annotation.JsonFormat;

@Service
public class AppointmentService implements IAppointmentService {

	@Autowired
	private IAppointmentRepository appointmentRepository;

	@Autowired
	private IApplicationRepository applicationRepository ;

	@Autowired
	private IRTOOfficeRepository officeRepository;

	@Override
	public ResponseEntity<String> createAppointment(String applicationNumber, Appointment appointment, int rtoId) {
		// TODO Auto-generated method stub
		Application appl;
		RTOOffice rtoOfc;
		Optional<Application> application = this.applicationRepository.findById(applicationNumber);
		if(!application.isPresent()) {
			return new ResponseEntity<String>("Application not found",HttpStatus.NOT_FOUND);
		}else {
			appl = application.get();
		}

		Optional<RTOOffice> rtoOffice = this.officeRepository.findById(rtoId);
		if(!rtoOffice.isPresent()) {
			return new ResponseEntity<String>("RTO Office not found",HttpStatus.NOT_FOUND); 
		} else {
			rtoOfc = rtoOffice.get();
		}

		Optional<Appointment> findAppointment = this.appointmentRepository.findById(appointment.getAppointmentNumber());
		try {
			if(!findAppointment.isPresent()) {
				appointment.setApplication(appl);
				appointment.setRtoOffice(rtoOfc);
				this.appointmentRepository.save(appointment);
				return new ResponseEntity<String>(HttpStatus.CREATED);
			}
			else {
				throw new RecordAlreadyPresentException("Appointment Already Present!!!");
			}
		} catch(RecordAlreadyPresentException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Appointment viewAppointmentDetails(String applicationNumber) {
		// TODO Auto-generated method stub
		Appointment appnt ;

		Optional<Application> application = this.applicationRepository.findById(applicationNumber);
		if(!application.isPresent()) {
			return null;
		}
		else {
			appnt = application.get().getAppointment();
		}
		try {
			return this.appointmentRepository.findById(appnt.getAppointmentNumber())
					.orElseThrow(() -> new RecordNotFoundException("No such appointments found!!!"));
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ResponseEntity<String> updateAppointment(Date testDate, Date timeSlot, String applicationNumber) {
		// TODO Auto-generated method stub
		Appointment appnt ;

		
		String newString = new SimpleDateFormat("HH:mm").format(timeSlot);
		try {
			Date testSlot = new SimpleDateFormat("HH:mm").parse(newString);
			
			Optional<Application> application = this.applicationRepository.findById(applicationNumber);
			if(!application.isPresent()) {
				return new ResponseEntity<String>("Application not found",HttpStatus.NOT_FOUND);
			}
			else {
				appnt = application.get().getAppointment();
			}
			try {
				Appointment findAppointment = this.appointmentRepository.findById(appnt.getAppointmentNumber())
						.orElseThrow(() -> new RecordNotFoundException("Appointment does not exist!!!"));
				findAppointment.setTestDate(testDate);
				findAppointment.setTimeSlot(testSlot);
				this.appointmentRepository.save(findAppointment);
				return new ResponseEntity<String>("Appointment rescheduled succesfully",HttpStatus.OK);
			} catch(RecordNotFoundException e) {
				//e.printStackTrace();
				return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
			}
			
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return new ResponseEntity<String>("Error in test slot format",HttpStatus.BAD_REQUEST);
		}
		
		
	}

	@Override
	public ResponseEntity<String> deleteAppointment(String applicationNumber) {
		// TODO Auto-generated method stub
		Appointment appnt ;

		Optional<Application> application = this.applicationRepository.findById(applicationNumber);
		if(!application.isPresent()) {
			return new ResponseEntity<String>("Application not found",HttpStatus.NOT_FOUND);
		}
		else {
			appnt = application.get().getAppointment();
		}
		try {
			Appointment findAppointment = this.appointmentRepository.findById(appnt.getAppointmentNumber())
					.orElseThrow(() -> new RecordNotFoundException("Appointment does not exist!!!"));
			this.appointmentRepository.delete(findAppointment);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch(RecordNotFoundException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}			
	}
}