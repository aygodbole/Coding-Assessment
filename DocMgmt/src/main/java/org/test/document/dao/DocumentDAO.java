/**
 * 
 */
package org.test.document.dao;

import java.util.HashMap;

import org.test.document.beans.Document;

/**
 * @author Aaditi Godbole
 *
 */
public class DocumentDAO {
	

	public HashMap<String, String> uploadDocument(Document doc) {
		
		HashMap<String, String> responseMap = new HashMap<String, String>();
		//Save document bean into table
		responseMap.put("STATUS", "SUCCESS");
		responseMap.put("msg", "File uploaded successfully");
		return responseMap;
	}

}
