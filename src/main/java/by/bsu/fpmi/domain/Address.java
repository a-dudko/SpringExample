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
	private UUID mId;
	
	public void setId(UUID id) {
		mId = id;
	}
	
	public UUID getId() {
		return mId;
	}
	
}
