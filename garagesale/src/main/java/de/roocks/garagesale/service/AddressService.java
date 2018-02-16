package de.roocks.garagesale.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.AddressEntity;
import de.roocks.garagesale.model.Address;

@Service
@Transactional
public class AddressService {

	@PersistenceContext
	private EntityManager em;

	public Address getAddressById(Long id) {
		AddressEntity addressEntity = em.find(AddressEntity.class, id);
		return mapEntityToAddress(addressEntity);
	}
	
	public Long storeAddress(Address address) {
		AddressEntity addressEntity = new AddressEntity(address);
		em.persist(addressEntity);
		return addressEntity.getId();
	}
	
	public void deleteAddressById(Long id) {
		AddressEntity addressEntity = em.find(AddressEntity.class, id);
		if (addressEntity != null) 
			em.remove(addressEntity);
	}
	
	public Address mapEntityToAddress(AddressEntity addressEntity) {
		if (addressEntity == null)
			return null;	
		Address address = new Address(addressEntity.getId(), addressEntity.getCountry(), addressEntity.getCity(), addressEntity.getStreet(),
				addressEntity.getHousenumber(), addressEntity.getPostcode(), addressEntity.getAdditionalinfo());
		return address;
	}
	
	/**
	 * Speichert die Addresse, falls die noch nicht in der DB vorhanden ist.
	 * 
	 */
	public AddressEntity getAddressIfExists(AddressEntity address) {
		
		List<AddressEntity> addresses = AddressEntity.GET_ALL(em).getResultList();
		AddressEntity result = addresses.stream().filter(x -> address.getCountry().equals(x.getCountry()))
				.filter(x -> address.getCity().equals(x.getCity()))
				.filter(x -> address.getStreet().equals(x.getStreet()))
				.filter(x -> address.getHousenumber().equals(x.getHousenumber()))
				.findAny()
				.orElse(address);
		if (result.getId() == null)
			em.persist(result);
		return result;
	}

}
