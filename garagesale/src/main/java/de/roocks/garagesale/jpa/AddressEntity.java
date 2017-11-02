package de.roocks.garagesale.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name ="address")
public class AddressEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
}
