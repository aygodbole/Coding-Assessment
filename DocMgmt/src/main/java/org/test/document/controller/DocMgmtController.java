/**
 * 
 */
package org.test.document.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.test.document.beans.Document;
import org.test.document.service.DocumentService;


/**
 * @author Aaditi Godbole
 *
 */
@Controller
public class DocMgmtController {
	
	@Autowired
	DocumentService documentService;
	
	@RequestMapping(value="/upload", method=RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> uploadDocument(@RequestParam("file") MultipartFile multipartFile, HttpServletRequest request){
		
		System.out.println(multipartFile.getContentType());
		System.out.println(multipartFile.getSize());
		
		HashMap<String, String> responseMap = new HashMap<String, String>();
		ResponseEntity<HashMap<String, String>> responseEntity = null;
		try {
			//get the request parameter
			String docId = request.getParameter("docId");
			String userName = request.getParameter("userName");
			
			//add details into document bean and pass to service
			Document docBean = new Document();
			docBean.setDocName(multipartFile.getOriginalFilename());
			docBean.setDocContent(multipartFile.getBytes());
			docBean.setDocId(Integer.parseInt(docId));
			docBean.setDocType(multipartFile.getContentType());
			docBean.setUserName(userName);
			
			responseMap = (HashMap<String, String>) documentService.uploadDocument(docBean);
			
			responseEntity = new ResponseEntity<HashMap<String, String>>(responseMap, HttpStatus.OK);
			
		} catch (IOException e) {
			responseMap.put("STATUS", "FAILURE");
			responseMap.put("msg", e.getLocalizedMessage());
			e.printStackTrace();
		}
		
		return responseEntity;
	}

	
}
