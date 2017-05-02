package com.testevalemobi.tools;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.FlushModeType;

import com.testevalemobi.model.dao.CustomerDao;
import com.testevalemobi.model.entity.Customer;
import com.testevalemobi.util.JPAUtil;
import com.testevalemobi.util.Properties;
import com.testevalemobi.util.Validator;

public class InsereCustomers {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.setFlushMode(FlushModeType.COMMIT);
		manager.getTransaction().begin();
		
		CustomerDao dao = new CustomerDao(manager);
		List<Customer> customers = new ArrayList<>();
		Customer c = null;
		
		//insere customers
		for(int i = 0; i < 30; i++){
			c = new Customer();
			c.setCpfCnpj(new Properties().getValue(String.valueOf(i)));
			
			// valida o cpf/cnpj e verifica se o cliente ja esta na lista que será inserida no banco de dados 
			if(!(Validator.isValido(c.getCpfCnpj())) || customers.contains(c)){
				continue;
			}
			c.setNameCustomer("Customer_"+i);
			c.setActive(true);
			c.setValorTotal(new BigDecimal(40 * new Random(50).nextDouble()* i + 100.0));
			customers.add(c);
		}
		
		dao.insereEmLote(customers);
		manager.getTransaction().commit();
		manager.close();
	}
}
