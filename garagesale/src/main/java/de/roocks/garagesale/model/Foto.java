package de.roocks.garagesale.model;

import lombok.Data;

@Data
public class Foto {
	
	private Long id;
	private byte[] foto;
	private Long productId;
	
	public Foto() {
		super();
	}

	public Foto(Long id, byte[] foto, Long productId) {
		super();
		this.id = id;
		this.foto = foto;
		this.productId = productId;
	}
}
