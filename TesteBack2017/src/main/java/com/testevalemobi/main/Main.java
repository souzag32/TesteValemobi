package com.testevalemobi.main;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.testevalemobi.model.dao.CustomerDao;
import com.testevalemobi.model.entity.Customer;
import com.testevalemobi.util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		CustomerDao dao = new CustomerDao(manager);
		
		List<Customer> customers = dao.customers(new BigDecimal(560), 1500, 2700);
		manager.close();
		
		System.out.println();
		BigDecimal mediaFinal = new BigDecimal(0);
		
		for(Customer c : customers){
			mediaFinal = mediaFinal.add(c.getValorTotal());
			System.out.println(c);
		}
		
		System.out.println("\nMedia Final: "+ mediaFinal.divide(new BigDecimal(customers.size()), 2));
	}
}
