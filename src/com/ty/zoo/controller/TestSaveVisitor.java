package com.ty.zoo.controller;

import java.util.Scanner;

import com.ty.zoo.dto.Visitor;
import com.ty.zoo.service.VisitorService;

public class TestSaveVisitor {

	public static void main(String[] args) {

		// creating Object of Visitor
		Visitor visitor = new Visitor();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the visitor id"); int id = sc.nextInt();sc.nextLine();
		System.out.println("Enter the Visitor name");String name = sc.nextLine() ;
		System.out.println("Enter the Visitor email");String email = sc.nextLine() ;
		System.out.println("Enter the Visitor phone");String phone = sc.nextLine() ;
		System.out.println("Enter the Visitor gender");String gender = sc.nextLine() ;
		System.out.println("Enter the Visitor age");int age = sc.nextInt() ;
		
		visitor.setId(id);
		visitor.setName(name);
		visitor.setEmail(email);
		visitor.setPhone(phone);
		visitor.setGender(gender);
		visitor.setAge(age);
		
		
		VisitorService service = new VisitorService() ;
		
		int res = service.saveVisitor(visitor) ;
		
		if( res != 0 ) System.out.println("Data inserted");
		else System.out.println("No data inserted");
		
		
		sc.close();
	}

}
