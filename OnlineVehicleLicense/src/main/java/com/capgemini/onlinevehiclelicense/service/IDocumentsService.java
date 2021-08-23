package com.capgemini.onlinevehiclelicense.service;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.onlinevehiclelicense.model.Documents;

public interface IDocumentsService {

	public ResponseEntity<String> updateDocuments(Documents doc, String app_number);
	public ResponseEntity<Resource> viewPhoto(String applicationId);
	public ResponseEntity<Resource> viewIdProof(String applicationId);
	public ResponseEntity<Resource> viewAddressProof(String applicationId);
	public ResponseEntity<String> deleteDocuments(String appl_number);
	public ResponseEntity<String> uploadPhoto(String id, MultipartFile photo);	
	public ResponseEntity<String> uploadIdProof(String id, MultipartFile idProof);
	public ResponseEntity<String> uploadAddressProof(String id, MultipartFile addressProof);
}
