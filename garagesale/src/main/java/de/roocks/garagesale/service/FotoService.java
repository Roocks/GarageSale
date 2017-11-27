package de.roocks.garagesale.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import de.roocks.garagesale.jpa.FotoEntity;
import de.roocks.garagesale.jpa.ProductEntity;

@Service
@Transactional
public class FotoService {

	@PersistenceContext
	private EntityManager em;

	public void storeFoto(Long productId, byte[] data) {
		ProductEntity productEntity = em.find(ProductEntity.class, productId);
		FotoEntity fotoEntity = new FotoEntity();
		fotoEntity.setProductEntity(productEntity);
		fotoEntity.setFoto(data);
		em.persist(fotoEntity);
	}

	public byte[] getFoto(Long id) {
		FotoEntity entity = em.find(FotoEntity.class, id);
		return entity.getFoto();
	}

	public void deleteFoto(Long id) {
		FotoEntity entity = em.find(FotoEntity.class, id);
		if (entity != null)
			em.remove(entity);
	}
}
