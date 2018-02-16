package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.AddressEntity;
import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.model.Address;
import de.roocks.garagesale.model.Customer;

@Service
@Transactional
public class CustomerService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private AddressService addressService;

	public Long storeCustomer(Customer customer) {
		CustomerEntity customerEntity = new CustomerEntity(customer);
		if (customer.getAddress() != null) {
			AddressEntity addressEntity = new AddressEntity(customer.getAddress());
			customerEntity.setAddress(addressService.getAddressIfExists(addressEntity));
		}
		em.persist(customerEntity);
		return customerEntity.getId();
	}

	public Customer getCustomerById(Long id) {
		CustomerEntity customerEntity = em.find(CustomerEntity.class, id);
		if (customerEntity != null) {
			Address address = addressService.mapEntityToAddress(customerEntity.getAddress());
			Customer customer = new Customer(customerEntity.getId(), customerEntity.getUsername(),
					customerEntity.getPassword(), customerEntity.getFirstname(), customerEntity.getSecondname(),
					customerEntity.getEmail(), address);
			return customer;
		}
		return null;
	}

	public void deleteCustomerById(Long id) {
		CustomerEntity customerEntity = em.find(CustomerEntity.class, id);
		if (customerEntity != null)
			em.remove(customerEntity);
	}
}
