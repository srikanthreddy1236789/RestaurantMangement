package com.project.sessionfactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.entity.Item;
import com.project.entity.OrderedItem;
import com.project.entity.User;

public class SessionFactoryConnection {
	private static SessionFactory sesfact;
	private SessionFactoryConnection()
	{
		sesfact=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).
				addAnnotatedClass(Item.class).addAnnotatedClass(OrderedItem.class).buildSessionFactory();
	}
	public static SessionFactory con()
	{
		SessionFactoryConnection s=new SessionFactoryConnection();
		return sesfact;
	}
	

}
