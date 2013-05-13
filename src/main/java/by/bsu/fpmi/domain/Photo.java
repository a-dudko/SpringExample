package by.bsu.fpmi.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PHOTO")
public class Photo {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID id;
	
	@Column(name="URL")
	private String url;
	
	@Column(name="DESCRIPTION")
	private String description;

	@ManyToOne
    @JoinColumn(name="PROFILE_ID")
	private Profile userProfile;
	
	public Photo() {
		// TODO Auto-generated constructor stub
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Profile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}
}
