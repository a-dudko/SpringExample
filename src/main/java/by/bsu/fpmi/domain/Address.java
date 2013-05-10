package by.bsu.fpmi.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ADRESSES")
public class Address {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private UUID id;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
}
