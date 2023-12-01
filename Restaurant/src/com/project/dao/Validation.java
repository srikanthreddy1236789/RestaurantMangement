package com.project.dao;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.project.entity.User;
import com.project.service.AdminService;
import com.project.service.UserService;
import com.project.sessionfactory.SessionFactoryConnection;

public class Validation {
	private SessionFactory sesfact;
	private Session ses;
	private Transaction tx;
	private AdminService adminservice;
	private UserService userservice;
	public Validation()
	{
		userservice=new UserService();
		sesfact = SessionFactoryConnection.con();
	}
	
	
	//logic for Admin is present or not
	public void adminCheck(String adminname, String adminpass) {
		adminservice=new AdminService();
		if(adminname.equalsIgnoreCase("admin")&& adminpass.equalsIgnoreCase(adminpass))
		{
			System.out.println("Welcome to Admin Page");
			adminservice.menu();
			
		}
		else
		{
			System.out.println("Invalid Details.....");
			System.exit(0);
		}
		
	}
	
	
	//logic for new Registration
	public void newRegister(int newid, String username, String password,String address,String phno) {
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		Query q=ses.createQuery("select u from User u where u.username=:name and u.password=:pass");
		q.setParameter("name", username);
		q.setParameter("pass", password);
		List<User> usrlst=q.list();
		if(usrlst.isEmpty())
		{
		User u=new User();
		u.setUserid(newid);
		u.setUsername(username);
		u.setPassword(password);
		u.setAddress(address);
		u.setPhonenumber(phno);
		ses.save(u);
		tx.commit();
		
		System.out.println("Sucessfully Inserted");
		}
		else
		{
			System.out.println("You Already Registered");
			System.exit(0);
		}
	}
	
	
	//logic for validating user
	public void checkUser(String user, String pass) {
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
	
		Query q=ses.createQuery("select u from User u where u.username=:un  and u.password=:ps");
		q.setParameter("un", user);
		q.setParameter("ps", pass);
		List<User> users=q.list();
		if(!users.isEmpty())
		{
			System.out.println("Welcome To User Page");
			for(User u:users)
			{
				userservice.menudisplay(u);
			}
				
				
			
			
		}
		else
		{
			System.out.println("Invalid Details");
		}
		
	}
	

}