package de.roocks.garagesale.model;

public class Foto {
	
	private Long id;
	private byte[] foto;
	private Long product_id;
	
	public Foto() {
		super();
	}

	public Foto(Long id, byte[] foto, Long productId) {
		super();
		this.id = id;
		this.foto = foto;
		this.product_id = productId;
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
		return product_id;
	}

	public void setProductId(Long productId) {
		this.product_id = productId;
	}
}
