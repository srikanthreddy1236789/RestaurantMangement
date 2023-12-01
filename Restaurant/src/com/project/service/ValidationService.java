package com.project.service;

import java.util.Scanner;

import com.project.dao.Validation;

public class ValidationService {
       private Validation valid;
       private Scanner sc;
       public ValidationService()
       {
    	   valid=new Validation();
    	   sc=new Scanner(System.in);
    	   
       }
       public void admin()
       {
    	   System.out.println("Enter the Admin Username");
    	   String adminname=sc.next();
    	   System.out.println("Enter the Admin Password");
    	   String adminpass=sc.next();
    	   valid.adminCheck(adminname,adminpass);
       }
       public void newRegistration()
       {
    	   System.out.println("Enter the User Id");
    	   int newid=sc.nextInt();
    	   System.out.println("Enter the User Name");
    	   String username=sc.next();
    	   System.out.println("Enter the PassWord");
    	   String password=sc.next();
    	   System.out.println("Enter the Address");
    	   String address=sc.next();
    	   System.out.println("Enter the Phone Number");
    	   String phno=sc.next();
    	   
    	   valid.newRegister(newid,username,password,address,phno);
    	   
       }
       public void check()
       {
    	   System.out.println(" Enter the Username ");
    	   String user=sc.next();
    	   System.out.println(" Enter the Password ");
    	   String pass=sc.next();
    	   valid.checkUser(user,pass);
    	   
       }
	
       

}