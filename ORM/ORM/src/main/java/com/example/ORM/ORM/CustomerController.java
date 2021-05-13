package com.example.ORM.ORM;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class CustomerController {
	@Autowired
	CustomerRepository repository;
	
	
	@GetMapping("/customers")
	List<Customer> all() {
		return repository.findAll();
	}

	private ArrayList<Customer> customers;
	public CustomerController() {
		Customers customers = new Customers();
		this.customers = new ArrayList<Customer>();
		this.customers = customers.getCustomers();
	}
/*
	@GetMapping("/customers")
	List<Customer> all() {
		return customers;
	}
	*/
	@PostMapping("/customers")
	  Customer newCustomer(@RequestBody Customer newCustomer) {
		customers.add(newCustomer);
		return newCustomer;
	  }
	
	@GetMapping("/customers/{id}")
	  Customer getCustomer(@PathVariable Long id) {
	    for (int i=0;i<=customers.size();i++) {
	    		if (customers.get(i).getCustomerId() == id) {
	    			return customers.get(i);
	    		}
	    }
	    return null;
	    }
	
	@PutMapping("customers/{id}")
	Customer updateCustomer(@RequestBody Customer rCustomer, @PathVariable Long id) {
		Customer custToReplace = null;
		for (int i=0;i<=customers.size();i++) {
	    		if (customers.get(i).getCustomerId() == id) {
	    			custToReplace = customers.get(i);
	    			break;
	    		}
		}
    		if (custToReplace != null) {
    			custToReplace.setCustomerName(rCustomer.getCustomerName());
    			custToReplace.setCustomerAddress(rCustomer.getCustomerAddress());

    			return custToReplace;
    		} else {
    			customers.add(rCustomer);
    			return rCustomer;
    		}
    		
	}
	
	@DeleteMapping("customers/{id}")
	void deleteCustomer(@PathVariable Long id) {	
		for (int i=0;i<=customers.size();i++) {
	    		if (customers.get(i).getCustomerId() == id) {
	    			customers.remove(i);
	    			break;
	    		}
		}		

	}
}
