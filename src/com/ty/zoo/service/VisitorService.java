package com.ty.zoo.service;

import com.ty.zoo.dao.VisitorDao;
import com.ty.zoo.dto.Visitor;
import com.ty.zoo.util.AES;
import static com.ty.zoo.util.UC.*;

public class VisitorService {

	VisitorDao dao = new VisitorDao() ;
	
	public int saveVisitor(Visitor visitor) {
		// encrypting data
		String encName = AES.encrypt(visitor.getName(), KEY);
		String encEmail = AES.encrypt(visitor.getEmail(), KEY);
		String encPhone = AES.encrypt(visitor.getPhone(), KEY);
		
		// assigning encrypted data into visitor object
		visitor.setName(encName);
		visitor.setEmail(encEmail);
		visitor.setPhone(encPhone);
		
		return dao.saveVisitor(visitor) ;
	}
	
	public Visitor getVisitorById(int id) {
		
		Visitor visitor = dao.getVisitorById(id) ;
		// encrypting data
		String encName = AES.decrypt(visitor.getName(), KEY);
		String encEmail = AES.decrypt(visitor.getEmail(),KEY);
		String encPhone = AES.decrypt(visitor.getPhone(), KEY);
		
		// assigning encrypted data into visitor object
		visitor.setName(encName);
		visitor.setEmail(encEmail);
		visitor.setPhone(encPhone);
		
		return visitor ;
	}
	
}
