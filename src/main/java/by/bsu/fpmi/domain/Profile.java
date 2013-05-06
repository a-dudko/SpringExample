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
	
	
	private Sex mSex;
	
	private Theme mTheme;
	
	private Collection<Photo> mPhotos;
	
	public UUID getmId() {
		return mId;
	}
	
	public void setmId(UUID mId) {
		this.mId = mId;
	}
	
	public Sex getmSex() {
		return mSex;
	}
	
	public void setmSex(Sex mSex) {
		this.mSex = mSex;
	}
	
	public Theme getmTheme() {
		return mTheme;
	}
	
	public void setmTheme(Theme mTheme) {
		this.mTheme = mTheme;
	}
	
	public Collection<Photo> getmPhotos() {
		return mPhotos;
	}
	
	public void setmPhotos(Collection<Photo> mPhotos) {
		this.mPhotos = mPhotos;
	}
}
