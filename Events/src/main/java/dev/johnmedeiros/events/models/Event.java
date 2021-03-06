package dev.johnmedeiros.events.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotNull
	@Size(min=2, max=50, message = "Name must be between 2-50 characters")
	private String name;
	@NotNull
	@Future 
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	@NotNull
	@Size(min=2, max=50, message = "Location must be between 2-50 characters")
	private String location;
	@NotNull
	private String state;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
    private List<Message> messages;
	
	@ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "event_members", 
	     joinColumns = @JoinColumn(name = "event_id"), 
	     inverseJoinColumns = @JoinColumn(name = "user_id")
	 )
	 private List<User> attendees;
	
	public Event() {
	}
	 
	 
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}



	public String getLocation() {
		return location;
	}



	public void setLocation(String location) {
		this.location = location;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }



	public List<User> getAttendees() {
		return attendees;
	}



	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}



	public List<Message> getMessages() {
		return messages;
	}



	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

}
