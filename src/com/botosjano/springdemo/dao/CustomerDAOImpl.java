package com.botosjano.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.botosjano.springdemo.entity.Customer;




@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// need to inject the session factory
	
	private SessionFactory sessionFactory;
	
	public CustomerDAOImpl() {
	
	}
	
	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Customer> getCustomers() {
		
		// get the current Hibernate session
		Session session = sessionFactory.getCurrentSession();
				
		// create a query ... sort by last name
		Query<Customer> query =
				session.createQuery("from Customer order by lastName",
									Customer.class);
		
		// execute query and get result list
		List<Customer> customers = query.getResultList();
		
		// return the result
		
		return customers;
	}

	@Override
	public void saveCustomers(Customer theCustomer) {
		
		// get current hibernate session
		Session session = sessionFactory.getCurrentSession();
		
		// save the customer...
		session.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomers(int theId) {
		
		// get current session
		Session session = sessionFactory.getCurrentSession();
		
		// retrieve/read from db using the primary key / id
		Customer theCustomer = session.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomers(int theId) {
		
		// get current session
		Session session = sessionFactory.getCurrentSession();
		
		// delete the Customer where id match with param id
		Query theQuery =
				session.createQuery("delete from Customer c where c.id =: customerId");
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomers(String theSearchName) {
		
		 // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        // only search by name if theSearchName is not empty
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // search for firstName or lastName ... case insensitive
            theQuery =currentSession.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName", Customer.class);
            theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName is empty ... so just get all customers
            theQuery =currentSession.createQuery("from Customer", Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = theQuery.getResultList();
                
        // return the results        
        return customers;
	}
	
	

	
}
