package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.AddressEntity;
import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.model.Customer;

@Service
@Transactional
public class CustomerService {
	
	@PersistenceContext
	private EntityManager em;

	public void addCustomer(Customer customer) {
		CustomerEntity entity = new CustomerEntity(customer);
		em.persist(entity);
	}

	public void addAddressToCustomer(Long customerId, Long addressId) {
		CustomerEntity customer = em.find(CustomerEntity.class, customerId);
		AddressEntity address = em.find(AddressEntity.class, addressId);
		customer.getAddresses().add(address);
		em.merge(customer);
	}

	public void setMainaddress(Long customerId, Long addressId) {
		CustomerEntity customer = em.find(CustomerEntity.class, customerId);
		AddressEntity address = em.find(AddressEntity.class, addressId);
		customer.setMainaddress(address);
		em.merge(customer);
	}
}
