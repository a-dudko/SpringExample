package by.bsu.fpmi.domain;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT")
public class Comment {

	@Id
	@Column(name="COMMENT_ID")
	@GeneratedValue
	private UUID id;
	
	@Column(name="TEXT")
	private String text;
	
	@Column(name="DATE")
	private Calendar date;
	
	@ManyToOne
    @JoinColumn(name="EVENT_ID")
	private Event event;
	
	@ManyToOne
    @JoinColumn(name="PROFILE_ID")
	private Profile userProfile;
	
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
	
	public Profile getUserProfile() {
		return userProfile;
	}
	
	public void setUserProfile(Profile userProfile) {
		this.userProfile = userProfile;
	}
}
