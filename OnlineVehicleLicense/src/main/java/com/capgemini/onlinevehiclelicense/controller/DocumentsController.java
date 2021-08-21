package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.service.IDocumentsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = "http://localhost:4205")
@RestController
@RequestMapping("/user/document")
public class DocumentsController {
	
	@Autowired
	private IDocumentsService documentsService;
	
	
	@ApiOperation("Upload Photo")
	@PostMapping("/{applicationNumber}/upload-photo")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> uploadPhoto(@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String id, 
			@RequestParam MultipartFile photo)
	{
		return documentsService.uploadPhoto(id, photo);
	}
	
	@ApiOperation("Upload Id Proof")
	@PostMapping("/{applicationNumber}/upload-idProof")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> uploadIdProof(@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String id, 
			@RequestParam MultipartFile idProof)
	{
		return documentsService.uploadIdProof(id, idProof);
	}
	
	@ApiOperation("Upload Address Proof")
	@PostMapping("/{applicationNumber}/upload-addressProof")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> uploadAddressProof(@ApiParam(value = "Application Number Param") @PathVariable("applicationNumber") String id,
			@RequestParam MultipartFile addressProof)
	{
		return documentsService.uploadAddressProof(id, addressProof);
	}
	
	@ApiOperation("Update Documents")
	@PutMapping("/update-documents/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> updateDocuments(@RequestBody Documents doc, @PathVariable("applicationNumber") String app_number){
		return this.documentsService.updateDocuments(doc, app_number);
	}
	
	@ApiOperation("View Documents")
	@GetMapping("/view-documents/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public Documents viewDocuments(@PathVariable("applicationNumber") String app_number) {
		return this.documentsService.viewDocuments(app_number);
	}
	
	@ApiOperation("Delete Documents")
	@DeleteMapping("delete-documents/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> deleteDocuments(@PathVariable("applicationNumber") String appl_number){
		return this.documentsService.deleteDocuments(appl_number);
	}
}
