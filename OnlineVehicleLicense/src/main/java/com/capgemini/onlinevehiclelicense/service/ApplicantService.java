package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.Users;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;


@Service
@Transactional
public class ApplicantService implements IApplicantService{
	@Autowired
	private IApplicantRepository applicantRepo;
	
	@Autowired
	private IUserService userService;
	
	/**
	 * method to add applicant profile
	 */
	@Override
	public ResponseEntity<String> addApplicant(String username, Applicant applicant){
		Users u = this.userService.getUserById(username);
		if(u!=null) {
			Optional<Applicant> findUser = this.applicantRepo.findById(username);
			try {
				if(!findUser.isPresent())
				{
					applicant.setApplicantId(username);
					applicant.setUsers(u);
					this.applicantRepo.save(applicant);
					return new ResponseEntity<String>("Applicant profile saved successfully.\nUsername: "+u.getUsername()+"\nApplicant id: "+applicant.getApplicantId(),HttpStatus.OK);
				}
				else
				{
					throw new RecordAlreadyPresentException("Applicant profile already exists");
				}
			}
			catch(RecordAlreadyPresentException e)
			{
				return new ResponseEntity<String>("Applicant profile already exists",HttpStatus.ALREADY_REPORTED);
			}
		}
		else {
			return new ResponseEntity<String>("User with the username:"+username+" not found",HttpStatus.NOT_FOUND);
		}
		/*
		try {
			return this.userRepo.findById(u.getEmail()).map(user -> {
			    applicant.setUsers(user);
			    this.applicantRepo.save(applicant);
			    return new ResponseEntity<String>(HttpStatus.OK);
			}).orElseThrow(() -> new RecordNotFoundException("User with the username:"+username+" not found"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}*/
		
	}

	/**
	 * method to update applicant profile
	 */
	@Override
	public ResponseEntity<String> updateApplicantDetails(String username, Applicant applicant) {
		Users u = this.userService.getUserById(username);
		if(u!=null) {
			try {
				Applicant findUser = this.applicantRepo.findById(username)
						.orElseThrow(() -> new RecordNotFoundException(username));
				findUser.setDateOfBirth(applicant.getDateOfBirth());
				findUser.setFirstName(applicant.getFirstName());
				findUser.setGender(applicant.getGender());
				findUser.setLastName(applicant.getLastName());
				findUser.setMiddleName(applicant.getMiddleName());
				findUser.setMobile(applicant.getMobile());
				findUser.setNationality(applicant.getNationality());
				findUser.setPlaceOfBirth(applicant.getPlaceOfBirth());
				findUser.setQualification(applicant.getQualification());
				findUser.setVehicleNumber(applicant.getVehicleNumber());
				findUser.setVehicleType(applicant.getVehicleType());
				this.applicantRepo.save(findUser);
				return new ResponseEntity<String>("Applicant profile updated successfully.\nUsername: "+u.getUsername()+"\nApplicant id: "+findUser.getApplicantId(),HttpStatus.OK);
			} catch (RecordNotFoundException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				return new ResponseEntity<String>("Applicant profile not found",HttpStatus.NOT_FOUND); 
			}
			
		}
		else {
			return new ResponseEntity<String>("User with the username:"+username+" not found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	/**
	 * method to remove applicant profile
	 */
	@Override
	public ResponseEntity<String> removeApplicant(String applicantNumber) {
		
		try {
				Applicant findUser = this.applicantRepo.findById(applicantNumber).orElseThrow(() -> new RecordNotFoundException("Application not found"));
				this.applicantRepo.delete(findUser);
				return new ResponseEntity<String>(HttpStatus.OK);
		}
		catch(RecordNotFoundException e)
		{
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}
	
	/**
	 * method to view applicant by id
	 */
	@Override
	public Applicant viewApplicantById(String username) {
		try {		
			Applicant findUser = this.applicantRepo.findById(username).orElseThrow(() -> new RecordNotFoundException("Applicant profile not found"));
				return findUser;
		}
		catch(RecordNotFoundException e)
		{
			e.getMessage();
			return null;
		}
	}

}
