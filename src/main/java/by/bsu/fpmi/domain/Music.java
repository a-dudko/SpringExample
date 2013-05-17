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
@Table(name="MUSIC")
public class Music {

	@Id
	@Column(name="MUSIC_ID")
	@GeneratedValue
	private Integer id;
	
	@Column(name="URL")
	private String url;
	
	@ManyToMany(mappedBy="musics")
	private Set<Event> events = new HashSet<Event>();
	
	public Music() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
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
