package com.capgemini.onlinevehiclelicense.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.service.IDocumentsService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user/document")
public class DocumentsController {
	
	@Autowired
	private IDocumentsService documentsService;
	
	/*
	@ApiOperation("Upload Documents")
	@PostMapping("/upload-documents")
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<Documents> uploadDocuments(@RequestBody Documents doc)
	{
		return documentsService.uploadDocuments(doc);
	}
	*/
	@ApiOperation("Update Documents")
	@PutMapping("/update-documents/{applicationNumber}")
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<Documents> updateDocuments(@RequestBody Documents doc,@PathVariable("applicationNumber") String app_number){
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
	public ResponseEntity<Documents> deleteDocuments(@PathVariable("applicationNumber") String appl_number){
		return this.documentsService.deleteDocuments(appl_number);
	}
}
