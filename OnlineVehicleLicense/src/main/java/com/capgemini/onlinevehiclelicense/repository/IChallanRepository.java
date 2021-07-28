package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Challan;

@Repository
public interface IChallanRepository extends JpaRepository<Challan, String> {

}