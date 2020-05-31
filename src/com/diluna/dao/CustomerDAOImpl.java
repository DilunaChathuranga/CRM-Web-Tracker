package com.diluna.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diluna.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		//create a query..sort by first name
		Query<Customer> theQuery=currentSession.createQuery("from Customer order by firstName",Customer.class);
		//execute query and get the result
		List<Customer> customers=theQuery.getResultList();
		//return the result
		return customers;
	}

	//hibenate api use two methods to save data to db 1->insert 2->update
	//this method is work for save and update
	@Override
	public void saveCustomer(Customer thecustomer) {
		
		//get the hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		//save the customer
		currentSession.saveOrUpdate(thecustomer);
	}

	@Override
	public Customer getCustomers(int theId) {
	
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		//now retrieve/read from db using the P.K(id)
		Customer theCustomer=currentSession.get(Customer.class,  theId);
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		//get the current hibernate session
		Session currentSession=sessionFactory.getCurrentSession();
		//Query
		Query theQuery=currentSession.createQuery("delete from Customer where id=:customerId");
		theQuery.setParameter("customerId", theId);
		
		//delete and update table
		theQuery.executeUpdate();
		
	}

}
