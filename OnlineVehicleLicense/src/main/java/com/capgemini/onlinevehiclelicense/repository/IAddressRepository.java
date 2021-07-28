package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capgemini.onlinevehiclelicense.model.Address;

@Repository
public interface IAddressRepository extends JpaRepository<Address, String > {

}
