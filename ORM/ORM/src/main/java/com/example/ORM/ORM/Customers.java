package com.example.ORM.ORM;

import java.util.ArrayList;

public class Customers {

		private ArrayList<Customer> customers;

		public Customers() {
			customers = new ArrayList<Customer>();
			customers.add(new Customer(1,"Radha","189 sanjose, CA"));
			customers.add(new Customer(2,"Moni", "166 freemont, CA"));
		}
		
		public ArrayList<Customer> getCustomers() {
			return customers;
		}
		public void setCustomers(ArrayList<Customer> customers) {
			this.customers = customers;
		}

	

	}

