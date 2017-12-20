/**
 * 
 */
package org.test.document.service.impl;

import java.io.File;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.test.document.beans.Document;
import org.test.document.dao.DocumentDAO;
import org.test.document.service.DocumentService;

/**
 * @author Aaditi Godbole
 *
 */
public class DocumentServiceImpl  implements DocumentService{

	@Autowired
	DocumentDAO documentDao;
	
	public File retrieveDocument(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<String, String> uploadDocument(Document doc) {
		return documentDao.uploadDocument(doc);
	}


}
