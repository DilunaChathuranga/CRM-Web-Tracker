package com.diluna.service;

import java.util.List;

import com.diluna.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);
}
