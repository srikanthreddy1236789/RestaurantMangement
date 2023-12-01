package com.project.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.project.entity.Item;
import com.project.entity.OrderedItem;
import com.project.entity.User;
import com.project.sessionfactory.SessionFactoryConnection;

public class UserDao {
	private SessionFactory sesfact;
	private Session ses;
	double totalAmount=0;
	private List<OrderedItem> orderlst;
	
	private Transaction tx;
	public UserDao()
	{
		orderlst=new ArrayList<OrderedItem>();
		sesfact = SessionFactoryConnection.con();
	}
	
	public void OrderItem(String itemname, int plates, User u)
	{
		
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		org.hibernate.query.Query q=ses.createQuery("select i from Item i where i.itemname=:name");
		q.setParameter("name", itemname);
		List<Item> ilst=q.list();
		if(!ilst.isEmpty())
		{
			for(Item i:ilst)
			{
				
				OrderedItem oi=new OrderedItem();
				oi.setDate(LocalDate.now());
				oi.setItemname(itemname);
				oi.setTotalprice(plates*i.getPrice());
				oi.setQuantity(plates);
				oi.setUserobj(u);
				orderlst.add(oi);
				ses.save(oi);
				totalAmount=totalAmount+plates*i.getPrice();
			}
			
		}
		else
		{
			System.out.println("No Item With That Name");
		}
		tx.commit();
	}
	
	public void generateBill()
	{
		for(OrderedItem olist:orderlst)
		{
			System.out.println(" - - - - - - - - - - - - - - -- - - - -- - - - - ");
			System.out.println("Item Name is   :"+olist.getItemname());
			System.out.println("No of Plates   :"+olist.getQuantity());
			System.out.println("total Price is  :"+olist.getTotalprice());
			System.out.println("- - - - - - - - - - - - - - - - - - - -- - - - -");
		}
		System.out.println(" $ $ $ $ $ $ $ $ $ $ $ $ $ $ $");
		System.out.println();
		System.out.println("total Bill is "+totalAmount);
		System.out.println();
		System.out.println("$ $ $ $ $ $ $ $ $ $ $ $ $ $ $  $");
		System.exit(0);
	}

	public void displayItemsMenu() {
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		org.hibernate.query.Query q1=ses.createQuery("from Item");
		List<Item> itm=q1.list();
		for(Item i:itm)
		{
			System.out.println("Item Name is   :"+i.getItemname());
			System.out.println("Item Price is  :"+i.getPrice());
			System.out.println("*****************************************");
		}
		
	}

	public void orderedHistory(User u) {
		ses=sesfact.openSession();
		tx=ses.beginTransaction();
		
		org.hibernate.query.Query q2=ses.createQuery("select o from OrderedItem o where o.userobj=:idd");
		q2.setParameter("idd", u);
		List<OrderedItem> olist=q2.list();
		if(!olist.isEmpty())
		{
			for(OrderedItem oi:olist)
			{
				System.out.println("Item name is "+oi.getItemname());
				System.out.println("Item Quantity  is "+oi.getQuantity());
				System.out.println("Price        "+oi.getTotalprice());
				System.out.println("Date is      "+oi.getDate());
				System.out.println("************************************************");
			}
		}
		else
		{
			System.out.println("No Such User with That ID");
		}	
		
	}

}