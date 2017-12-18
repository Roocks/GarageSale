package de.roocks.garagesale.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.AddressEntity;
import de.roocks.garagesale.model.Address;

@Service
@Transactional
public class AddressService {

	@PersistenceContext
	private EntityManager em;

	public void storeAddress(Address address) {
		AddressEntity entity = new AddressEntity(address);
		em.persist(entity);
	}

	public Address getAddressById(Long id) {
		AddressEntity entity = em.find(AddressEntity.class, id);
		return convertEntitiyToAddress(entity);
	}

	public void deleteAddressById(Long id) {
		AddressEntity entity = em.find(AddressEntity.class, id);
		if (entity != null)
			em.remove(entity);
	}
	
	public List<Address> getAllAddresses() {
		TypedQuery<AddressEntity> query = AddressEntity.GET_ALL(em);
		List<Address> addressList = new ArrayList<Address>();
		for (AddressEntity entity : query.getResultList()) {
			addressList.add(convertEntitiyToAddress(entity));
		}
		return addressList;
	}
	
	public Address convertEntitiyToAddress(AddressEntity entity) {
		if (entity == null)
			return null;
		
		Address address = new Address(entity.getId(), entity.getCountry(), entity.getCity(), entity.getStreet(),
				entity.getHousenumber(), entity.getPostcode(), entity.getAdditionalinfo());
		return address;
	}

}
