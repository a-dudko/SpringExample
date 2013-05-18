package by.bsu.fpmi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name="ROLE")
public class Role implements GrantedAuthority{

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name="ID")
    @GeneratedValue
	private Integer id;
	
	@Column(name="AUTHORITY")
	private Roles authority;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Role() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority.toString();
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Roles getRole() {
		return authority;
	}
	
	public void setRole(Roles role) {
		this.authority = role;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}
