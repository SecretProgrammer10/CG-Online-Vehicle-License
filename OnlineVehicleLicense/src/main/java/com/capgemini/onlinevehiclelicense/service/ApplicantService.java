package com.capgemini.onlinevehiclelicense.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import com.capgemini.onlinevehiclelicense.model.User;
import com.capgemini.onlinevehiclelicense.repository.IApplicantRepository;

@Service
public class ApplicantService implements IApplicantService{
	@Autowired
	IApplicantRepository applicantRepo;
	@Override
	public String addApplicant(Applicant applicant){
		Optional<Applicant> findUser = applicantRepo.findById(applicant.getApplicantNumber());
		try {
			if(!findUser.isPresent())
			{
				applicantRepo.save(applicant);
				return "applicant profile created";
			}
			else
			{
				throw new RecordAlreadyPresentException("This applicant profile is already in use");
			}
		}
		catch(RecordAlreadyPresentException e)
		{
			return e.getMessage();
		}
	}
	@Override
	public String updateApplicantDetails(Applicant applicant) {
		Optional<Applicant> findUser = applicantRepo.findById(applicant.getApplicantNumber());
		try {
			if(!findUser.isPresent())
			{
				applicantRepo.save(applicant);
				return "applicant profile updated";
			}
			else
			{
				throw new RecordNotFoundException("applicant profile not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}
	@Override
	public String removeApplicant(Applicant applicant) {
		Optional<Applicant> findUser = applicantRepo.findById(applicant.getApplicantNumber());
		try {
			if(!findUser.isPresent())
			{
				applicantRepo.deleteById(applicant.getApplicantNumber());
				return "applicant profile deleted";
			}
			else
			{
				throw new RecordNotFoundException("applicant profile not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}
	@Override
	public String viewApplicantDetails(Applicant applicant) {
		Optional<Applicant> findUser = applicantRepo.findById(applicant.getApplicantNumber());
		try {
			if(!findUser.isPresent())
			{
				Applicant applicantFinder = findUser.get();
				return applicantFinder.toString();
			}
			else
			{
				throw new RecordNotFoundException("applicant profile not found");
			}
		}
		catch(RecordNotFoundException e)
		{
			return e.getMessage();
		}
	}

}
