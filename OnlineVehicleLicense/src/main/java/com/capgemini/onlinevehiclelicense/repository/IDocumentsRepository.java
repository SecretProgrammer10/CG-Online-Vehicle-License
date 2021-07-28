package com.capgemini.onlinevehiclelicense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinevehiclelicense.model.Documents;

@Repository
public interface IDocumentsRepository extends JpaRepository<Documents, String> {

}
