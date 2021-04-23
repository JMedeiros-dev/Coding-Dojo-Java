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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reviews")
public class Review {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @NotEmpty
	 @Size(min=2, max=120)
	 private String reviewer;
	 @Size(min=5, max=255, message = "Pro Tip: A good review should have be between 5 and 255 characters!")
	 private String response;
	 @NotNull
	 private Integer rating;
	 
	 @Column(updatable=false)
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date createdAt;
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date updatedAt;
	
	 
	 
	//==================================
	//    ONE TO MANY WITH LISTING
	//==================================
		
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="listing_id")
	    private Listing listing;
	 
	 
	 
	 //==================================
	 //   MANY TO MANY WITH GUESTS
	 //==================================
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	        name = "guest_reviews", 
	        joinColumns = @JoinColumn(name = "review_id"), 
	        inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<User> users;
	 
	 
	 
	 
	 public String getReviewer() {
		return reviewer;
	}


	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}


	public Review() {

	}
	 
	
	public Review(String response, Integer rating) {
		this.response = response;
		this.rating = rating;
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getResponse() {
		return response;
	}



	public void setResponse(String response) {
		this.response = response;
	}



	public Integer getRating() {
		return rating;
	}



	public void setRating(Integer rating) {
		this.rating = rating;
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
	//   GETTERS AND SETTERS FOR MANY TO ONE WITH LISTING
	//=======================================================


	public Listing getListing() {
		return listing;
	}


	public void setListing(Listing listing) {
		this.listing = listing;
	}

	//=======================================================
	//   GETTERS AND SETTERS FOR MANY TO MANY WITH GUESTS
	//=======================================================

	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	} 
	 
}
