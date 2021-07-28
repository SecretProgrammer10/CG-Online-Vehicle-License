package com.capgemini.onlinevehiclelicense.service;

import com.capgemini.onlinevehiclelicense.model.Address;
import com.capgemini.onlinevehiclelicense.model.Documents;

public interface IDocumentsService {
	public String createDocuments(Documents doc);
	public String updateDocuments(Documents doc, String app_number);
	public String viewDocuments(String app_number);
	public String deleteDocuments(String appl_number);
}
