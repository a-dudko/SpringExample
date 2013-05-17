package by.bsu.fpmi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ADRESS")
public class Address {

	@Id
    @Column(name="ID")
    @GeneratedValue
	private Integer id;
	
	@Column(name="LATITUDE")
	private double latitude;
	
	@Column(name="LONGITUDE")
	private double longitude;
	
	@Column(name="INFO")
	private String info;
	
	@OneToMany(mappedBy="address")
	private Set<Event> events = new HashSet<Event>();
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public Set<Event> getEvents() {
		return events;
	}
}
