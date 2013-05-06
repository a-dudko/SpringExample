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
	private UUID mId;
	
	@Column(name="URL")
	private String mUrl;
	
	private Collection<Event> mEvents;
	
	public void setId(UUID id) {
		mId = id;
	}
	
	public UUID getId() {
		return mId;
	}
	
	public void setUrl(String url) {
		mUrl = url;
	}
	
	public String getUrl() {
		return mUrl;
	}
	
	public void setmEvents(Collection<Event> mEvents) {
		this.mEvents = mEvents;
	}
	
	public Collection<Event> getmEvents() {
		return mEvents;
	}
	
	public void setmUrl(String mUrl) {
		this.mUrl = mUrl;
	}
	
	public String getmUrl() {
		return mUrl;
	}
}
