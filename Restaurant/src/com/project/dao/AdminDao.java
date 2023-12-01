package com.project.dao;
import com.project.entity.*;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import com.project.sessionfactory.SessionFactoryConnection;



public class AdminDao {
	private SessionFactory sesfact;
	private Session ses;
	private Transaction tx;
	
	public AdminDao()
	{
		sesfact = SessionFactoryConnection.con();
	}
	public void dispalyUsers()
	{
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		org.hibernate.query.Query  q=ses.createQuery("From User");
		List<User> userlst=q.list();
		for(User u:userlst) 
		{
			System.out.println("--------------------------------------------");
			System.out.println("User Id is   "+u.getUserid());
			System.out.println("User Name is "+u.getUsername());
			System.out.println("PassWord is  "+u.getPassword());
			System.out.println("Phone Number is "+u.getPhonenumber());
			System.out.println("Address is      "+u.getAddress());
			System.out.println("---------------------------------------------");
			
		}
	}
	public void updateUser(int id,String phone) {
		ses=sesfact.openSession();
		tx=ses.beginTransaction();	
		User uobj=ses.find(User.class, id);
		if(uobj!=null)
		{
			System.out.println("Find the data");
			uobj.setPhonenumber(phone);
			tx.commit();
			System.out.println("Sucessfully Updated");
	     }
		else
		{
			System.out.println("No data Found With that ID");
		}
	}
	
	public void deleteExistingUser(int deleteid) 
	{
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		User uobj=ses.find(User.class, deleteid);
		if(uobj!=null)
		{
			ses.delete(uobj);
			tx.commit();
			System.out.println("Sucessfully Deleted");
		}
		else
		{
			System.out.println("No data Found With that ID");
		}
		
	}

	public void updateItem(int itemid, double newprice)
	{
		
		ses=sesfact.openSession();
		tx=ses.beginTransaction();	
		Item iobj=ses.find(Item.class, itemid);
		if(iobj!=null)
		{
			System.out.println("Find the data");
			iobj.setPrice(newprice);
			tx.commit();
			System.out.println("Sucessfully Updated");
	     }
		else
		{
			System.out.println("No data Found With that ID");
		}
		
	}
	public void deleteItem(int deleteid)
	{
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		Item iobj=ses.find(Item.class, deleteid);
		if(iobj!=null)
		{
			ses.delete(iobj);
			tx.commit();
			System.out.println("Sucessfully Deleted");
		}
		else
		{
			System.out.println("No data Found With that ID");
		}
	}
	
	public void dispalyItems()
	{
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		org.hibernate.query.Query q1=ses.createQuery("from Item");
		List<Item> itemlst=q1.list();
		for(Item i:itemlst) 
		{
			System.out.println("Item Id is    "+i.getItemcode());
			System.out.println("Item name is  "+i.getItemname());
			System.out.println("Item price is "+i.getPrice());
			System.out.println("--------------------------------------");
			
			
		}
		
	}
	
	public void insertNewUser(List<User> userlst)
	{
		
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		for(User u:userlst)
		{
			User user=new User();
			user.setUserid(u.getUserid());
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setAddress(u.getAddress());
			user.setPhonenumber(u.getPhonenumber());
			ses.save(user);
			System.out.println("Sucessfully Inserted");

		}
		tx.commit();
	}
	
	public void insertNewItems(List<Item> itmlst) 
	{
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		for(Item i:itmlst)
		{
			Item itm=new Item();
			itm.setItemcode(i.getItemcode());
			itm.setItemname(i.getItemname());
			itm.setPrice(i.getPrice());
			ses.save(itm);
			System.out.println("Sucessfully Inserted");

			
		}
		tx.commit();	
	}
	
	public void todayBill()
	{
		double todayBill=0;
		LocalDate date=LocalDate.now();
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		org.hibernate.query.Query q4=ses.createQuery("select o from OrderedItem o where o.date=:date");
		q4.setParameter("date", date);
		List<OrderedItem> oitems=q4.list();
		for(OrderedItem i:oitems)
		{
			todayBill=todayBill+i.getTotalprice();
			
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Total Bill Generated today is   :"+todayBill);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
	}
	
	public void userOrders(int id)
	{
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		User user=ses.find(User.class, id);
		if(user!=null)
		{
			List<OrderedItem> orderitems=user.getOderitemlst();
			if(!orderitems.isEmpty())
			{
			for(OrderedItem oi:orderitems)
			{
				System.out.println("------------------------------------");
				System.out.println("Order Id is  "+oi.getOrderid());
				System.out.println("item name is  "+oi.getItemname()); 
				System.out.println("item price is  "+oi.getTotalprice());
				System.out.println("order Date is   "+oi.getDate());
				
				System.out.println("--------------------------------------");
			}
			}
			else
			{
				System.out.println("**********************************");
				System.out.println("No Items Purchased this User");
				System.out.println("**********************************");

			}
			
		}
		else
		{
			System.out.println("**********************************");
			System.out.println("Wrong user Id");
			System.out.println("**********************************");
		}
		
		
	}
	
	public void monthBill()
	{
		double todayBill1=0;
		LocalDate date=LocalDate.now();
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		org.hibernate.query.Query  q4 = ses.createQuery("From OrderedItem i where month(i.date) = MONTH(CURRENT_DATE)");
		List<OrderedItem> oitems=q4.list();
		for(OrderedItem i:oitems)
		{
			todayBill1=todayBill1+i.getTotalprice();
			
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("Total Bill Generated today is   :"+todayBill1);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	
	
	
	
	
	
	
	

}
