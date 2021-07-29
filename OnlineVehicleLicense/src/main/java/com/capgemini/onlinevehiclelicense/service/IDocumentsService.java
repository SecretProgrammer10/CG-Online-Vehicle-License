package com.capgemini.onlinevehiclelicense.service;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Documents;

public interface IDocumentsService {
	public ResponseEntity<Object> createDocuments(Documents doc);
	public ResponseEntity<Documents> updateDocuments(Documents doc, String app_number);
	public ResponseEntity<Documents> viewDocuments(String app_number);
	public ResponseEntity<Documents> deleteDocuments(String appl_number);
}
