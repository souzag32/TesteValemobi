package com.testevalemobi.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_customer_account")
public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(initialValue=1490, name="id_sequence", sequenceName="id_sequence")
	@GeneratedValue(generator="id_sequence")
	@Column(name = "id_customer")
	private Long idCustomer;
	
	@Column(name = "cpf_cnpj")
	private String cpfCnpj;
	
	@Column(name = "nm_customer")
	private String nameCustomer;
	
	@Column(name = "is_active")
	private boolean isActive;
	
	@Column(name = "vl_total", precision=10, scale=2)
	private BigDecimal valorTotal;
	
	//Getters e Setters
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getCpfCnpj() {
		return cpfCnpj;
	}
	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}
	public String getNameCustomer() {
		return nameCustomer;
	}
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpfCnpj == null) ? 0 : cpfCnpj.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (cpfCnpj == null) {
			if (other.cpfCnpj != null)
				return false;
		} else if (!cpfCnpj.equals(other.cpfCnpj))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "idCustomer => " + idCustomer + "; \tcpfCnpj => " + cpfCnpj + "; \tnameCustomer => " + nameCustomer
				+ "; \tisActive => " + isActive + "; \tvalorTotal => " + valorTotal;
	}
	
}
