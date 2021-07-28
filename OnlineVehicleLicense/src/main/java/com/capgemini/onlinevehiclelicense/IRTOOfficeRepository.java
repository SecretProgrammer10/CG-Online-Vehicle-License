package com.capgemini.onlinevehiclelicense.dao;

import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.RTOOffice;


import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface IRTOOfficeRepository extends JpaRepository<RTOOffice,Integer> {

}
