package com.project.service;

import java.util.Scanner;

import com.project.dao.UserDao;
import com.project.entity.User;

public class UserService {
	private Scanner sc;
	private UserDao user;
	public UserService()
	{
		sc=new Scanner(System.in);
		user=new UserDao();
		
	}
	public void menudisplay(User u)
	{
		
		displayItems();
		boolean ch=true;
		while(ch)
		{
			System.out.println("1. Order item using name");
			System.out.println("2. Generate Bill");
			System.out.println("3. Order History");
			System.out.println("4.  ***   Exit    ***");
			int choice =sc.nextInt();
			switch(choice)
			{
			case 1:orderUsingName(u);
			      break;
			case 2:user.generateBill();
			       break;
			case 3:orderHistory(u);
			       break;
			case 4:System.exit(0);
			       break;	
			}
			
		}
		
		
	}
	public void orderUsingName(User u)
	{
		System.out.println("Enter the itemname");
		String itemname=sc.next();
		System.out.println("How Many Plates");
		int plates=sc.nextInt();
		user.OrderItem(itemname,plates,u);
	}
	
	public void displayItems()
	{
		user.displayItemsMenu();
		
	}
	public void orderHistory(User u)
	{
		
		user.orderedHistory(u);
	}
	
}