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

	public Long storeFoto(Long productId, byte[] data) {
		ProductEntity productEntity = em.find(ProductEntity.class, productId);
		if (productEntity == null)
			return null;
		FotoEntity fotoEntity = new FotoEntity();
		fotoEntity.setProductEntity(productEntity);
		fotoEntity.setFoto(data);
		em.persist(fotoEntity);
		return fotoEntity.getId();
	}

	public byte[] getFoto(Long id) {
		FotoEntity fotoEntity = em.find(FotoEntity.class, id);
		return fotoEntity.getFoto();
	}

	public void deleteFoto(Long id) {
		FotoEntity fotoEntity = em.find(FotoEntity.class, id);
		if (fotoEntity != null)
			em.remove(fotoEntity);
	}
}
