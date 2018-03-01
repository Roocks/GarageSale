package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.CustomerEntity;
import de.roocks.garagesale.jpa.TokenEntity;
import de.roocks.garagesale.model.Token;

@Service
@Transactional
public class TokenService {

	@PersistenceContext
	private EntityManager em;

	public void storeToken(Token token) {
		TokenEntity tokenEntity = new TokenEntity();
		CustomerEntity customerEntity = em.find(CustomerEntity.class, token.getCustomer().getId());
		TokenEntity storedToken = em.find(TokenEntity.class, token.getCustomer().getId());
		if (storedToken != null)
			em.remove(storedToken);
		tokenEntity.setCustomerEntity(customerEntity);
		tokenEntity.setValue(token.getValue());
		em.persist(tokenEntity);
	}

	public boolean isValidToken(String value) {
		try {
			TokenEntity.FIND_BY_VALUE(em, value).getSingleResult();
			return true;
		} catch (NoResultException e) {
			return false;
		}
	}

}
