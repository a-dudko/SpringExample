package by.bsu.fpmi.domain;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="MUSIC")
public class Music {

	@Id
	@Column(name="MUSIC_ID")
	@GeneratedValue
	private UUID id;
	
	@Column(name="URL")
	private String url;
	
	@ManyToMany(mappedBy="musics")
	private Set<Event> events = new HashSet<Event>();
	
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
	
	public Set<Event> getEvents() {
		return events;
	}
	
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
