package com.diluna.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diluna.dao.CustomerDAO;
import com.diluna.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	//needto inject customer dao
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		//delegate calls to DAO
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer thecustomer) {
		//delegate calls to DAO
		customerDAO.saveCustomer(thecustomer);
	}

	@Override
	@Transactional
	public Customer getCustomers(int theId) {
		//delegate calls to DAO
		return customerDAO.getCustomers(theId);
	}

	@Override
	@Transactional
	public void deleteCustomer(int theId) {
		//delegate calls to DAO
		 customerDAO.deleteCustomer(theId);
	}
}
