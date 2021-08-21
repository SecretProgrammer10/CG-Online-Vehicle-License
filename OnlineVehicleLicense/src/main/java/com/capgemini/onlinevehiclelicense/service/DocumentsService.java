package com.capgemini.onlinevehiclelicense.service;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.capgemini.onlinevehiclelicense.exception.FileSizeExceededException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.repository.IDocumentsRepository;

@Service
public class DocumentsService implements IDocumentsService{

	@Autowired
	private IDocumentsRepository documentsRepository;
	

	@Override
	public ResponseEntity<String> updateDocuments(Documents doc, String app_number) {
		// TODO Auto-generated method stub
		try {
			Documents matchDocuments = this.documentsRepository.findById(app_number)
					.orElseThrow(() -> new RecordNotFoundException("Document Not Found!!!"));
			matchDocuments.setPhoto(doc.getPhoto());
			matchDocuments.setIdProof(doc.getIdProof());
			matchDocuments.setAddressProof(doc.getAddressProof());
			this.documentsRepository.save(matchDocuments);
			return ResponseEntity.ok().build();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return  new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}		

	}

	@Override
	public Documents viewDocuments(String app_number) {
		// TODO Auto-generated method stub
		try {
			return this.documentsRepository.findById(app_number)
					.orElseThrow(() -> new RecordNotFoundException("Document Not Found!!!"));
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return null;
		}
	}

	@Override
	public ResponseEntity<String> deleteDocuments(String appl_number) {
		// TODO Auto-generated method stub
		try {
			Documents matchDocuments = this.documentsRepository.findById(appl_number)
					.orElseThrow( () -> new RecordNotFoundException("Document Not Found!!!"));
			this.documentsRepository.delete(matchDocuments);
			return ResponseEntity.ok().build();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return  new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<String> uploadPhoto(String id, MultipartFile photo) {
		// TODO Auto-generated method stub
		try {
			Documents docs = this.documentsRepository.findById(id)
					.orElseThrow(() -> new RecordNotFoundException("Application not found"));
			
			if(photo.getBytes().length > 5242880) {
				throw new FileSizeExceededException("Max File Size Exceeded...");
			}
			
			docs.setPhoto(photo.getBytes());
			this.documentsRepository.save(docs);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Invalid File...", HttpStatus.EXPECTATION_FAILED);
		} catch (FileSizeExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("File Uploaded Successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> uploadIdProof(String id, MultipartFile idProof) {
		// TODO Auto-generated method stub
		try {
			Documents docs = this.documentsRepository.findById(id)
					.orElseThrow(() -> new RecordNotFoundException("Application not found"));
			
			if(idProof.getBytes().length > 5242880) {
				throw new FileSizeExceededException("Max File Size Exceeded...");
			}
			
			docs.setIdProof(idProof.getBytes());
			this.documentsRepository.save(docs);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Invalid File...", HttpStatus.EXPECTATION_FAILED);
		} catch (FileSizeExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("File Uploaded Successfully", HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> uploadAddressProof(String id, MultipartFile addressProof) {
		// TODO Auto-generated method stub
		try {
			Documents docs = this.documentsRepository.findById(id)
					.orElseThrow(() -> new RecordNotFoundException("Application not found"));
			
			if(addressProof.getBytes().length > 5242880) {
				throw new FileSizeExceededException("Max File Size Exceeded...");
			}
			
			docs.setAddressProof(addressProof.getBytes());
			this.documentsRepository.save(docs);
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>("Invalid File...", HttpStatus.EXPECTATION_FAILED);
		} catch (FileSizeExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
		}
		return new ResponseEntity<String>("File Uploaded Successfully", HttpStatus.OK);
	}

}
