package by.bsu.fpmi.domain;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PROFILES")
public class Profile {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID mId;
	
	
	
	public UUID getmId() {
		return mId;
	}
	
	public void setmId(UUID mId) {
		this.mId = mId;
	}
	
}
