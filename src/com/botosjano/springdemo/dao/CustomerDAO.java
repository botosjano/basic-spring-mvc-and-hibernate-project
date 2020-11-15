package com.botosjano.springdemo.dao;

import java.util.List;

import com.botosjano.springdemo.entity.Customer;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomers(Customer theCustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomers(int theId);

	public List<Customer> searchCustomers(String theSearchName);
	
}
