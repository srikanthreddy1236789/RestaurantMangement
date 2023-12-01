package com.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.project.entity.*;

import com.project.dao.AdminDao;

public class AdminService {
	private Scanner sc;
	private AdminDao admin;
	private List<User> userlst;
	private List<Item> itmlst;
	public AdminService()
	{
		sc=new Scanner(System.in);
		admin=new AdminDao();
		userlst=new ArrayList<User>();
		itmlst=new ArrayList<Item>();
	}
	public void updateUser()
	{
		System.out.println("Enter the User Id");
		int id=sc.nextInt();
		System.out.println("Enter the New PhoneNumber");
		String phone=sc.next();
		admin.updateUser(id,phone);
	}
	public void newUser()
	{
		System.out.println("How many Number of Users do you want insert ");
		int noofuser=sc.nextInt();
		for(int i=0;i<noofuser;i++)
		{
			User u=new User();
		  System.out.println("Enter the User Id");
 	      u.setUserid(sc.nextInt());
 	      System.out.println("Enter the User Name");
 	      u.setUsername(sc.next());
 	      System.out.println("Enter the PassWord");
 	      u.setPassword(sc.next());
 	      System.out.println("Enter the Address");
 	      u.setAddress(sc.next());
 	      System.out.println("Enter the Phone Number");
 	      u.setPhonenumber(sc.next());
 	      userlst.add(u);
		}
		admin.insertNewUser(userlst);
	}
	
	
	public void deleteUser()
	{
		System.out.println("Enter the Id Which u want to delete");
		int deleteid=sc.nextInt();
		admin.deleteExistingUser(deleteid);
	}
	public void displayUser()
	{
		admin.dispalyUsers();
	}
	
	public void insertItems()
	{
		System.out.println("How Many Items Do You Want To Insert");
		int noofitems=sc.nextInt();
		for(int i=0;i<noofitems;i++)
		{
			Item itm=new Item();
			System.out.println("Enter the Item Code");
			itm.setItemcode(sc.nextInt());
			System.out.println("Enter The Item Name");
			itm.setItemname(sc.next());
			System.out.println("Enter the Item Price");
		    itm.setPrice(sc.nextDouble());
			itmlst.add(itm);
		}
		admin.insertNewItems(itmlst);
	}
	
	public void updatingItem()
	{
		System.out.println("Enter the Item Id u want to Update");
		int itemid=sc.nextInt();
		System.out.println("Enter the new Price");
		double newprice=sc.nextDouble();
		admin.updateItem(itemid,newprice);
	}
	
	public void deletingItem()
	{
		System.out.println("Enter the ItemId to delete");
		int deleteid=sc.nextInt();
		admin.deleteItem(deleteid);
	}
	public void displayItem()
	{
		admin.dispalyItems();
	}
	public void crudUser()
	{
		String choice="y";
		int ch=0;
		
		while(choice.equalsIgnoreCase("y"))
		{
	    System.out.println("--------------------------------------------------------");
		System.out.println("1.****   Display Users          **********");
		System.out.println("2.****   Insert New Users       **********");
		System.out.println("3.****   Update Existing User   **********");
		System.out.println("4.****    Delete Existing User   *********");
		System.out.println("5.****    Exit App    *********");
		System.out.println("----------------------------------------------------------");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:displayUser();
		       break;
		case 2:newUser();
	           break;
		case 3:updateUser();
		       break;
		case 4:deleteUser();
		      break;
		case 5:System.exit(0);
		       break;
		
		}
		System.out.println("Do you want to Continue in CRUD operations : press 'y' else press 'n'");
		choice=sc.next();
		
		
		}
	}
	public void crudOnItems()
	{
		String choice="y";
		int ch=0;
		
		while(choice.equalsIgnoreCase("y"))
		{
	    System.out.println("--------------------------------------------------------");
		System.out.println("1.****   Display Items          **********");
		System.out.println("2.****   Insert New Items       **********");
		System.out.println("3.****   Update Existing Item   **********");
		System.out.println("4.****    Delete Existing Item   *********");
		System.out.println("5.****    Exit App               *********");
		System.out.println("----------------------------------------------------------");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:displayItem();
		       break;
		case 2:insertItems();
	           break;
		case 3:updatingItem();
		       break;
		case 4:deletingItem();
		      break;
		case 5:System.exit(0);
		       break;
		
		}
		System.out.println("Do you want to Continue in CRUD operations : press 'y' else press 'n'");
		choice=sc.next();
		
		
		}
	}
	public void menu()
	{
		String choice="y";
		int ch=0;
		
		while(choice.equalsIgnoreCase("y"))
		{
	    System.out.println("--------------------------------------------------------");
		System.out.println("1.**** CRUD Operations on User   ***");
		System.out.println("2.**** CRUD Operations on Item   ***");
		System.out.println("3.****    Today Bill     **********");
		System.out.println("4.****    Particular User Order History  **********");
		System.out.println("5.****    Bill For This Month     **********");
		System.out.println("6.******      Exit         ***********");
		System.out.println("----------------------------------------------------------");
		ch=sc.nextInt();
		switch(ch)
		{
		case 1:crudUser();
		       break;
		case 2:crudOnItems();
		       break;
		case 3:generatedTodayBill();
		       break;
		case 4:userOrderHistory();
		       break;
		case 5:thisMonthSale();
		       break;
		case 6:System.exit(0);
		}
		System.out.println("---------------------------------------------");
		System.out.println("Do You Want To Continue(Y/N)");
		System.out.println("----------------------------------------------");
		choice=sc.next();
		}
		
	}
	public void generatedTodayBill()
	{
		admin.todayBill();
	}
	public void userOrderHistory()
	{
		System.out.println("Enter the User id");
		int id=sc.nextInt();
		admin.userOrders(id);
	}
	public void thisMonthSale()
	{
		admin.monthBill();
	}

	
	
}
