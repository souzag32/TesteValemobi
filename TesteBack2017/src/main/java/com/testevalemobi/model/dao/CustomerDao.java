package com.testevalemobi.model.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.testevalemobi.model.entity.Customer;

public class CustomerDao implements Serializable{

	private static final long serialVersionUID = 1L;

	private EntityManager manager;
	
	public CustomerDao(EntityManager manager){
		this.manager = manager;
	}
	
	/**
	 * retorna uma lista de clientes cujo o saldo seja maior que o saldo passado por parametro, e o id esteja entre o menorId
	 * e maiorId tambem passados por parametro
	 * @param saldo 
	 * @param menorId; 
	 * @param maiorId;
	 * @return lista de clientes que atendem as condicoes
	 */
	public List<Customer> customers(BigDecimal saldo, long menorId, long maiorId){
		TypedQuery<Customer> query = manager.createQuery("from Customer c where c.valorTotal > :saldo "
													   + "and c.idCustomer between :id_customer1 and :id_customer2"
													   + " order by c.valorTotal desc",Customer.class);
		query.setParameter("saldo", saldo);
		query.setParameter("id_customer1", menorId);
		query.setParameter("id_customer2", maiorId);
		
		return query.getResultList();
	}
	
	/**
	 * Metodo que insere em lotes
	 * @param customers
	 */
	public void insereEmLote(List<Customer> customers){
		int batchSize = 20;		
		for(int i = 0; i < customers.size(); i++){
			manager.persist(customers.get(i));
			
			if(i % batchSize == 0 && i > 0){
				manager.flush();
				manager.clear();
			}
		}
	}
	
}
