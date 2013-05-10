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
	private UUID id;
	
	private Sex sex;
	
	private Theme theme;
	
	private Collection<Photo> photos;
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public Collection<Photo> getPhotos() {
		return photos;
	}
	
	public void setPhotos(Collection<Photo> photos) {
		this.photos = photos;
	}
}
