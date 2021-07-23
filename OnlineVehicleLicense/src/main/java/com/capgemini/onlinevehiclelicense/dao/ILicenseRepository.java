package com.capgemini.onlinevehiclelicense.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.License;

@Repository
public interface ILicenseRepository extends JpaRepository<License, String> {

}
