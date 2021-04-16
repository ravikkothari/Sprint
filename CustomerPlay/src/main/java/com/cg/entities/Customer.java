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
	 private String password;
	 
	 @OneToMany(targetEntity = CustomerPlaycard.class, cascade = CascadeType.ALL)
	 @JoinColumn(name = "cp_fk", referencedColumnName = "cust_Id")
	 private List<CustomerPlaycard> CustomerPlaycard;
	

	public Customer() {
		super();

	}

	

	public Customer(int id, String name, int age, String password,
			List<com.cg.entities.CustomerPlaycard> customerPlaycard) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.password = password;
		CustomerPlaycard = customerPlaycard;
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

	public List<CustomerPlaycard> getCustomerPlaycard() {
		return CustomerPlaycard;
	}

	public void setCustomerPlaycard(List<CustomerPlaycard> customerPlaycard) {
		CustomerPlaycard = customerPlaycard;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", password=" + password
				+ ", CustomerPlaycard=" + CustomerPlaycard + "]";
	}

	
	
}
