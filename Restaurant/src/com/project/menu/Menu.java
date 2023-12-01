package com.project.menu;

import java.util.Scanner;

import com.project.service.AdminService;
import com.project.service.ValidationService;

public class Menu {
	private Scanner sc;
	private AdminService adminservice;
	private ValidationService validservice;
	public Menu()
	{
		sc=new Scanner(System.in);
		adminservice=new AdminService();
		validservice=new ValidationService();
	}
	
	public void menuDisplay()
	{

	String choice="y";
	int ch=0;
	while(choice.equals("y"))
	{
		System.out.println("Enter your Choice");
		System.out.println("1.Login As A Admin");
		System.out.println("2.Login As A User");
		System.out.println("3.New Register");
		
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:validservice.admin();
		       break;
		
			
		case 2: validservice.check();
	             break;
		      
		       
		case 3:validservice.newRegistration();
		       break;
		
		}
	
	System.out.println("Do You Want To Continue(y/n)");
	choice=sc.next();
	}
	}
}
