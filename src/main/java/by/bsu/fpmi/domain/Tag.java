package by.bsu.fpmi.domain;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TAGS")
public class Tag {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID mId;
	
	@Column(name="TEXT")
	private String mText;
	
	public UUID getmId() {
		return mId;
	}
	
	private Collection<Event> mEvents;
	
	public void setmId(UUID mId) {
		this.mId = mId;
	}
	
	public String getmText() {
		return mText;
	}
	
	public void setmText(String mText) {
		this.mText = mText;
	}
	
	public Collection<Event> getmEvents() {
		return mEvents;
	}
	
	public void setmEvents(Collection<Event> mEvents) {
		this.mEvents = mEvents;
	}
}
