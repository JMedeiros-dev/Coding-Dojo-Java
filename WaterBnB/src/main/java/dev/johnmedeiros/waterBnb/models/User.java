package dev.johnmedeiros.waterBnb.models;

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
	 @Email(message = "Please enter a valid email")
	 @Size(min=5, max=50, message = "Email must be between 2-50 characters")
	 private String email;
	 @NotNull
	 private String type;
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
	 
	 //==================================
	 //   ONE TO MANY WITH LISTINGS
	 //==================================
	 
	 @OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	 private List<Listing> listings;
	 
	 //==================================
	 //   MANY TO MANY WITH REVIEWS
	 //==================================
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "guest_reviews", 
	        joinColumns = @JoinColumn(name = "user_id"), 
	        inverseJoinColumns = @JoinColumn(name = "review_id")
	    )
	    private List<Review> reviews;
	 
	 
	 
	 public User() {
	}
	 
	 
	public User(String firstName, String lastName, String email, String type,  String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.type = type;
		this.password = password;
	}





	public Long getId() {
		return id;
	}





	public void setId(Long id) {
		this.id = id;
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





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getType() {
		return type;
	}





	public void setType(String type) {
		this.type = type;
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





	@PrePersist
	 protected void onCreate(){
	     this.createdAt = new Date();
	 }
	 @PreUpdate
	 protected void onUpdate(){
	     this.updatedAt = new Date();
	 }


	//=======================================================
	//   GETTERS AND SETTERS FOR ONE TO MANY WITH LISTINGS
	//=======================================================
	 
	public List<Listing> getListings() {
		return listings;
	}


	public void setListings(List<Listing> listings) {
		this.listings = listings;
	}

	
	//=======================================================
	//   GETTERS AND SETTERS FOR MANY TO MANY WITH REVIEWS
	//=======================================================

	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	 

}
