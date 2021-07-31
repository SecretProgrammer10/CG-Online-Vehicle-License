package com.capgemini.onlinevehiclelicense.service;

//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

//import com.capgemini.onlinevehiclelicense.exception.RecordAlreadyPresentException;
import com.capgemini.onlinevehiclelicense.exception.RecordNotFoundException;
//import com.capgemini.onlinevehiclelicense.model.Application;
import com.capgemini.onlinevehiclelicense.model.Documents;
import com.capgemini.onlinevehiclelicense.repository.IDocumentsRepository;

@Service
public class DocumentsService implements IDocumentsService{

	@Autowired
	private IDocumentsRepository documentsRepository;
	
	
/*	@Override
	public ResponseEntity<Documents> uploadDocuments(Documents doc) {
		// TODO Auto-generated method stub
		Optional<Documents> documents = this.documentsRepository.findById(doc.getApplication());
		try {
			if(!documents.isPresent()) {
				this.documentsRepository.save(doc);
				return ResponseEntity.ok().build();
			}
			else {
				throw new RecordAlreadyPresentException("Documents already uploaded!!!");
			}
		} catch (RecordAlreadyPresentException e) {
			//e.printStackTrace();
			return new ResponseEntity<Documents>(HttpStatus.ALREADY_REPORTED);
		}
		
		
		
		
	}
*/
	@Override
	public ResponseEntity<Documents> updateDocuments(Documents doc, String app_number) {
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
			return  new ResponseEntity<Documents>(HttpStatus.NOT_FOUND);
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
	public ResponseEntity<Documents> deleteDocuments(String appl_number) {
		// TODO Auto-generated method stub
		try {
			Documents matchDocuments = this.documentsRepository.findById(appl_number)
					.orElseThrow( () -> new RecordNotFoundException("Document Not Found!!!"));
			this.documentsRepository.delete(matchDocuments);
			return ResponseEntity.ok().build();
		} catch (RecordNotFoundException e) {
			// TODO Auto-generated catch block
			return  new ResponseEntity<Documents>(HttpStatus.NOT_FOUND);
		}
	}

}
