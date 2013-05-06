package by.bsu.fpmi.domain;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMENTS")
public class Comment {

	@Id
	@Column(name="ID")
	@GeneratedValue
	private UUID mId;
	
	@Column(name="TEXT")
	private String mText;
	
	@Column(name="DATE")
	private Calendar mDate;
	
	
	private Event mEvent;
	
	
	
	public UUID getmId() {
		return mId;
	}
	
	public void setmId(UUID mId) {
		this.mId = mId;
	}
	
	public String getmText() {
		return mText;
	}
	
	public void setmText(String mText) {
		this.mText = mText;
	}
	
	public Calendar getmDate() {
		return mDate;
	}
	
	public void setmDate(Calendar mDate) {
		this.mDate = mDate;
	}
	
	public Event getmEvent() {
		return mEvent;
	}
	
	public void setmEvent(Event mEvent) {
		this.mEvent = mEvent;
	}
}
