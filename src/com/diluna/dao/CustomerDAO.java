package com.diluna.dao;

import java.util.List;
import com.diluna.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer thecustomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);
}
