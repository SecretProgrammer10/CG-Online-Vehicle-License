package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.onlinevehiclelicense.model.Application;

@Repository
public interface IApplicationRepository extends JpaRepository<Application, String> {

}
