package by.bsu.fpmi.domain;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAGS")
public class Tag {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID id;
	
	@Column(name="TEXT")
	private String text;
	
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public UUID getId() {
		return id;
	}
	
	private Collection<Event> events;
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Collection<Event> getEvents() {
		return events;
	}
	
	public void setEvents(Collection<Event> events) {
		this.events = events;
	}
}
