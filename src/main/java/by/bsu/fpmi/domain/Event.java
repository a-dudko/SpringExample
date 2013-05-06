package by.bsu.fpmi.domain;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//add field for collection and annotation for it
@Entity
@Table(name = "EVENTS")
public class Event {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private UUID mId;
	
	@Column(name="NAME")
	private String mName;
	
	@Column(name="DESCRIPTION")
	private String mDescription;
	
	@Column(name="TIME")
	private Calendar mTime;
	
	public void setId(UUID id) {
		mId = id;
	}
	
	public UUID getId() {
		return mId;
	}
	
	public void setName(String name) {
		mName = name;
	}
	
	public String getName() {
		return mName;
	}
	
	public void setDescription(String description) {
		mDescription = description;
	}
	
	public String getDescription() {
		return mDescription;
	}
	
	public void setTime(Calendar time) {
		mTime = time;
	}
	
	public Calendar getTime() {
		return mTime;
	}
}
