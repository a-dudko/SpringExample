package by.bsu.fpmi.domain;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENTS")
public class Comment {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID id;
	
	@Column(name="TEXT")
	private String text;
	
	@Column(name="DATE")
	private Calendar date;
	
	
	private Event event;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
	
	public Event getEvent() {
		return event;
	}
	
	public void setEvent(Event event) {
		this.event = event;
	}
}
