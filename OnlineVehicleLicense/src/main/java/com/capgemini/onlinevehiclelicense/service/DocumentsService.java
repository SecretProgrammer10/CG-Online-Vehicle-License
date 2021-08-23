package com.capgemini.onlinevehiclelicense.service;


import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

	@Override
	public ResponseEntity<Resource> viewPhoto(String applicationId) {
		// TODO Auto-generated method stub
		Optional<Documents> docs = this.documentsRepository.findById(applicationId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=photo")
				.contentType(MediaType.APPLICATION_PDF)
				.body(new ByteArrayResource(docs.get().getPhoto()));
	}

	@Override
	public ResponseEntity<Resource> viewIdProof(String applicationId) {
		// TODO Auto-generated method stub
		Optional<Documents> docs = this.documentsRepository.findById(applicationId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=idProof")
				.contentType(MediaType.APPLICATION_PDF)
				.body(new ByteArrayResource(docs.get().getIdProof()));
	}

	@Override
	public ResponseEntity<Resource> viewAddressProof(String applicationId) {
		// TODO Auto-generated method stub
		Optional<Documents> docs = this.documentsRepository.findById(applicationId);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=addressProof")
				.contentType(MediaType.APPLICATION_PDF)
				.body(new ByteArrayResource(docs.get().getAddressProof()));
	}

}
