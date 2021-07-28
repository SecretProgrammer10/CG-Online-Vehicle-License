package com.capgemini.onlinevehiclelicense.repository;
import com.capgemini.onlinevehiclelicense.model.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IApplicantRepository extends JpaRepository<Applicant, String>{
	
}
