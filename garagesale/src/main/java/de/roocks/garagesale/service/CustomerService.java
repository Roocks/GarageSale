package de.roocks.garagesale.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.AddressEntity;
import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.jpa.ParcelEntity;
import de.roocks.garagesale.model.Address;
import de.roocks.garagesale.model.Customer;

@Service
@Transactional
public class CustomerService {
	
	@PersistenceContext
	private EntityManager em;

	public void storeCustomer(Customer customer) {
		CustomerEntity entity = new CustomerEntity(customer);
		em.persist(entity);
	}

	public void addAddressToCustomer(Long customerId, Long addressId) {
		CustomerEntity entity = em.find(CustomerEntity.class, customerId);
		AddressEntity address = em.find(AddressEntity.class, addressId);
		entity.getAddresses().add(address);
		em.merge(entity);
	}

	public void setMainaddress(Long customerId, Long addressId) {
		CustomerEntity entity = em.find(CustomerEntity.class, customerId);
		AddressEntity address = em.find(AddressEntity.class, addressId);
		entity.setMainaddress(address);
		em.merge(entity);
	}

	public Customer getCustomerById(Long id) {
		CustomerEntity entity = em.find(CustomerEntity.class, id);
		return convertEntityToCustomer(entity);
	}

	public void deleteCustomerById(Long id) {
		CustomerEntity entity = em.find(CustomerEntity.class, id);
		if(entity != null)
			em.remove(entity);
	}
	
	public Customer convertEntityToCustomer(CustomerEntity entity) {
		if (entity == null)
			return null;
		// Liste mit Parcel-IDs
		List<Long> parcelIds = new ArrayList<Long>();
		for(ParcelEntity e : entity.getParcels()) {
			parcelIds.add(e.getId());
		}
		
		// Liste mit vollständigen Addressen
		AddressService as = new AddressService();
		List<AddressEntity> addressEntities = entity.getAddresses();
		List<Address> addresses = new ArrayList<Address>();
		for (AddressEntity e : addressEntities) {
			addresses.add(as.convertEntitiyToAddress(e));
		}
		
		// Hauptadresse = Lieferadresse
		Address mainaddress  = as.convertEntitiyToAddress(entity.getMainaddress());

		// Customer
		Customer customer = new Customer(entity.getId(), entity.getUsername(), entity.getPassword(), entity.getFirstname(), entity.getSecondname(), entity.getEmail(), mainaddress, addresses, parcelIds);
		return customer;
	}
}
