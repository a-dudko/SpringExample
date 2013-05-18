package by.bsu.fpmi.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


//add field for collection and annotation for it
@Entity
@Table(name = "EVENT")
public class Event {

	@Id
    @Column(name="EVENT_ID")
    @GeneratedValue
	private Integer id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="TIME")
	private Calendar time;
	
	@ManyToOne
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
	
	@OneToMany(mappedBy="event")
	private Set<Comment> comments = new HashSet<Comment>();
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="EVENT_MUSIC", 
    	joinColumns={@JoinColumn(name="EVENT_ID")}, 
    	inverseJoinColumns={@JoinColumn(name="MUSIC_ID")})
	private Set<Music> musics = new HashSet<Music>();

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="EVENT_TAG", 
    	joinColumns={@JoinColumn(name="EVENT_ID")}, 
    	inverseJoinColumns={@JoinColumn(name="TAG_ID")})
	private Set<Tag> tags = new HashSet<Tag>();

	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="EVENT_PROFILE", 
    	joinColumns={@JoinColumn(name="EVENT_ID")}, 
    	inverseJoinColumns={@JoinColumn(name="PROFILE_ID")})
	private Set<Profile> userProfiles = new HashSet<Profile>();
	
	public Event() {
		// TODO Auto-generated constructor stub
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
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
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public Set<Music> getMusics() {
		return musics;
	}
	
	public void setMusics(Set<Music> musics) {
		this.musics = musics;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}
	
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public Set<Profile> getUserProfiles() {
		return userProfiles;
	}
	
	public void setUserProfiles(Set<Profile> userProfiles) {
		this.userProfiles = userProfiles;
	}
}
