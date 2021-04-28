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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 private Long id;
 @NotNull
 @Size(min=2, max=50, message = "First Name must be between 2-50 characters")
 private String firstName;
 @NotNull
 @Size(min=2, max=50, message = "Last Name must be between 2-50 characters")
 private String lastName;
 @NotNull
 @Size(min=2, max=50, message = "Location must be between 2-50 characters")
 private String location;
 @NotNull
 private String state;
 @NotNull
 @Email(message = "Please enter a valid email")
 @Size(min=5, max=50, message = "Email must be between 2-50 characters")
 private String email;
 @NotNull
 @Size(min=5, message = "Password must be at least 5 characters long")
 private String password;
 @Transient
 private String passwordConfirmation;
 @Column(updatable=false)
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date createdAt;
 @DateTimeFormat(pattern="yyyy-MM-dd")
 private Date updatedAt;
 
 @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
 private List<Event> events;
 
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "event_members", 
     joinColumns = @JoinColumn(name = "user_id"), 
     inverseJoinColumns = @JoinColumn(name = "event_id")
 )
 private List<Event> eventsAttending;
 
 public User() {
 }
 
 
 public String getFirstName() {
	return firstName;
}


public void setFirstName(String firstName) {
	this.firstName = firstName;
}

	
public String getLastName() {
	return lastName;
}


public void setLastName(String lastName) {
	this.lastName = lastName;
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


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getPasswordConfirmation() {
	return passwordConfirmation;
}

public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
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

public List<Event> getEvents() {
	return events;
}


public void setEvents(List<Event> events) {
	this.events = events;
}


@PrePersist
 protected void onCreate(){
     this.createdAt = new Date();
 }
 @PreUpdate
 protected void onUpdate(){
     this.updatedAt = new Date();
 }


public List<Event> getEventsAttending() {
	return eventsAttending;
}


public void setEventsAttending(List<Event> eventsAttending) {
	this.eventsAttending = eventsAttending;
}
}
