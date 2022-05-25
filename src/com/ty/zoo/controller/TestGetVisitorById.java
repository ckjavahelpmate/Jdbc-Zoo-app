package com.ty.zoo.controller;

import java.util.Scanner;

import com.ty.zoo.dto.Visitor;
import com.ty.zoo.service.VisitorService;

public class TestGetVisitorById {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the visitor id"); int id = sc.nextInt();

		VisitorService service = new VisitorService() ;
		
		Visitor visitor = service.getVisitorById(id) ;
		
		System.out.println(visitor);
		
		sc.close();

	}

}
