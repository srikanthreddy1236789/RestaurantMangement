package com.project.entity;
import javax.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name="OrderedItems")

public class OrderedItem {
	@Id
	@GeneratedValue
	@Column(name="OrderId")
	private int orderid;
	
	@Column(name="DateOfOrder")
	private LocalDate date;
	@Column(name="TotalSpend")
	private double totalprice;
    @Column(name="ItemName")
    private String itemname;
    @Column(name="Quantity")
    private int quantity;
	@ManyToOne
	@JoinColumn(name="UserIdFk")
	private User userobj;
	
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate localDate) {
		this.date = localDate;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public User getUserobj() {
		return userobj;
	}
	public void setUserobj(User userobj) {
		this.userobj = userobj;
	}
	
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	

}