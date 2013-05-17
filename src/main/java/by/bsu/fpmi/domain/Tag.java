package by.bsu.fpmi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TAG")
public class Tag {

	@Id
	@Column(name="TAG_ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="TEXT")
	private String text;
	
	@ManyToMany(mappedBy="tags")
	private Set<Profile> userProfiles = new HashSet<Profile>();
	
	@ManyToMany(mappedBy="tags")
	private Set<Event> events = new HashSet<Event>();
	
	public Tag() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Set<Profile> getUserProfiles() {
		return userProfiles;
	}
	
	public void setUserProfiles(Set<Profile> userProfiles) {
		this.userProfiles = userProfiles;
	}
	
	public Set<Event> getEvents() {
		return events;
	}
	
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
