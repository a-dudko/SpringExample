package by.bsu.fpmi.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PHOTOS")
public class Photo {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID mId;
	
	@Column(name="URL")
	private String mUrl;

	public UUID getmId() {
		return mId;
	}
	
	public void setmId(UUID mId) {
		this.mId = mId;
	}
	
	public String getmUrl() {
		return mUrl;
	}
	
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
}
