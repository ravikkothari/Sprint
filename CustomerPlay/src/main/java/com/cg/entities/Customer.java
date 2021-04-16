package com.cg.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	 @Id
	 @Column(name="cust_Id")
	 private int id;
	 private String name;
	 private int age;
	 
	 @OneToMany(targetEntity = Cart.class, cascade = CascadeType.ALL)
	 @JoinColumn(name = "cp_fk", referencedColumnName = "cust_Id")
	 private List<Cart> cart;
	
	 public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	 
	
}
