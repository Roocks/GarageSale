package de.roocks.garagesale.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TypedQuery;

import de.roocks.garagesale.model.Token;

@Entity
@Table(name="token")
@NamedQueries({
	@NamedQuery (name = TokenEntity.QUERY_FIND_BY_VALUE, query = "SELECT s FROM TokenEntity  s WHERE s.value =:value")
})
public class TokenEntity {

	public static final String QUERY_FIND_BY_VALUE = "TokenEntity.findByValue";

	@Id
	private Long id;
	
	@Column(name ="value")
	private String value;
	
	@Column(name = "created_on")
	private Date createdDate;
	
	@OneToOne (fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "user_id")
	private CustomerEntity customerEntity;
	
	public TokenEntity() {
		super();
		this.createdDate = new Date();
	}

	public TokenEntity(Token token) {
		this.value = token.getValue();
		this.createdDate = new Date();
		this.customerEntity = new CustomerEntity(token.getCustomer());
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	@Override
	public String toString() {
		return "TokenEntity [id=" + id + ", value=" + value + ", createdDate=" + createdDate + ", customerEntity="
				+ customerEntity + "]";
	}

	public static TypedQuery<TokenEntity> FIND_BY_VALUE(EntityManager em, String value) {
		TypedQuery<TokenEntity> query = em.createNamedQuery(QUERY_FIND_BY_VALUE, TokenEntity.class)
				.setParameter("value", value);			
		return query;
	}
}
