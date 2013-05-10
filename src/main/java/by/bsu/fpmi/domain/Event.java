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
	private UUID id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TIME")
	private Calendar time;
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setTime(Calendar time) {
		this.time = time;
	}
	
	public Calendar getTime() {
		return time;
	}
}
