package by.bsu.fpmi.domain;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MUSICS")
public class Music {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID id;
	
	@Column(name="URL")
	private String url;
	
	private Collection<Event> events;
	
	public Music() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(UUID id) {
		this.id = id;
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setEvents(Collection<Event> events) {
		this.events = events;
	}
	
	public Collection<Event> getEvents() {
		return events;
	}
}
