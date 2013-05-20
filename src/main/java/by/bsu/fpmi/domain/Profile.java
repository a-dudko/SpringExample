package by.bsu.fpmi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name="PROFILE")
public class Profile {

	@Id
	@Column(name="PROFILE_ID")
	@GeneratedValue
	private Integer id;

	@Column(name="LOGIN")
	private String login;
	
	@Column(name="PASSWORD")
	private int password;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="SEX")
	@Enumerated(EnumType.STRING)
	private Sex sex;
	
	@Column(name="AGE")
	private Integer age;
	
	@Column(name="THEME")
	@Enumerated(EnumType.STRING)
	private Theme theme;
	
	@OneToMany(mappedBy="userProfile")
	private Set<Photo> photos = new HashSet<Photo>();
	 
	@OneToMany(mappedBy="userProfile")
	private Set<Comment> comments = new HashSet<Comment>();
	
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="PROFILE_TAG", 
    	joinColumns={@JoinColumn(name="PROFILE_ID")}, 
	    inverseJoinColumns={@JoinColumn(name="TAG_ID")})
	private Set<Tag> tags = new HashSet<Tag>();
	
    @ManyToMany(mappedBy="userProfiles")
    private Set<Event> events = new HashSet<Event>();
    
    @ManyToMany(cascade={CascadeType.ALL})
    @JoinTable(name="PROFILE_LIKE",
        joinColumns={@JoinColumn(name="PROFILE_ID")},
        inverseJoinColumns={@JoinColumn(name="LIKED_PROFILE_ID")})
	private Set<Profile> likedUserProfiles = new HashSet<Profile>();
	
    @ManyToMany(mappedBy="likedUserProfiles")
    private Set<Profile> likedProfiles = new HashSet<Profile>();
    
	public Profile() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public int getPassword() {
		return password;
	}
	
	public void setPassword(int password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Sex getSex() {
		return sex;
	}
	
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Theme getTheme() {
		return theme;
	}
	
	public void setTheme(Theme theme) {
		this.theme = theme;
	}
	
	public Set<Photo> getPhotos() {
		return photos;
	}
	
	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}
	
	public Set<Comment> getComments() {
		return comments;
	}
	
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}
	
	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}
	
	public Set<Profile> getLikedUserProfiles() {
		return likedUserProfiles;
	}
	
	public void setLikedUserProfiles(Set<Profile> likedUserProfiles) {
		this.likedUserProfiles = likedUserProfiles;
	}
	
	public Set<Event> getEvents() {
		return events;
	}
	
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
	
	public Set<Profile> getLikedProfiles() {
		return likedProfiles;
	}
	
	public void setLikedProfiles(Set<Profile> likedProfiles) {
		this.likedProfiles = likedProfiles;
	}
}