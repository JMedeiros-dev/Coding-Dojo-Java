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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="listings")
public class Listing {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min=10, max=75, message = "Address must be between 10-75 characters")
	private String address;
	@NotEmpty
	@Size(min=10, max=500, message = "Pro Tip: The most active listings have a description between 10-500 characters")
	private String description;
	@NotNull
	private Integer cost;
	@NotNull
	private String pool;
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	
	//==================================
	//   MANY TO ONE WITH HOSTS
	//==================================
	
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
    
    
     //==================================
  	 //   ONE TO MANY WITH REVIEWS
  	 //==================================
  	 
  	 @OneToMany(mappedBy="listing", fetch = FetchType.LAZY)
  	 private List<Review> reviews;
	
	
	
	public Listing() {
	}
	
	
	public Listing(String address, String description, Integer cost, String pool) {
		super();
		this.address = address;
		this.description = description;
		this.cost = cost;
		this.pool = pool;
	}

	
	

	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getAddress() {
		return address;
	}




	public void setAddress(String address) {
		this.address = address;
	}




	public String getDescription() {
		return description;
	}




	public void setDescription(String description) {
		this.description = description;
	}




	public Integer getCost() {
		return cost;
	}




	public void setCost(Integer cost) {
		this.cost = cost;
	}




	public String getPool() {
		return pool;
	}




	public void setPool(String pool) {
		this.pool = pool;
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

	 
	 
	//================================================
	//  GETTERS AND SETTERS FOR MANY TO ONE W/ HOSTS
	//================================================

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}

	
	//================================================
	//  GETTERS AND SETTERS FOR ONE TO MANY W/ HOSTS
	//================================================


	public List<Review> getReviews() {
		return reviews;
	}


	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
