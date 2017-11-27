package de.roocks.garagesale.model;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}
}
