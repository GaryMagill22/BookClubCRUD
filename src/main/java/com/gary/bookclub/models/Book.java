package com.gary.bookclub.models;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="books")
public class Book {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	
	@NotEmpty(message="Title is required!")
    @Size(min=1, message="Title must not be blank!")
    private String title;
	
	@NotEmpty(message="Author is required!")
    @Size(min=1, message="Author must not be blank!")
    private String author;
	
	@NotEmpty(message="Thoughts is required!")
    @Size(min=1, max=300, message="Thoughts must not be blank!")
    private String thoughts;
	
	// Adding One to Many Relationship
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="owner_id")
		private User owner;
	
		
		
		  @Column(updatable=false)
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date createdAt;
		    @DateTimeFormat(pattern="yyyy-MM-dd")
		    private Date updatedAt;
			

		    
		
		public Book(String title, String author, String thoughts) {
			this.title = title;
			this.author = author;
			this.thoughts = thoughts;
		}
		
		
		
		
		
		public Long getId() {
			return id;
		}





		public void setId(Long id) {
			this.id = id;
		}





		public String getTitle() {
			return title;
		}





		public void setTitle(String title) {
			this.title = title;
		}





		public String getAuthor() {
			return author;
		}





		public void setAuthor(String author) {
			this.author = author;
		}





		public String getThoughts() {
			return thoughts;
		}





		public void setThoughts(String thoughts) {
			this.thoughts = thoughts;
		}





		public User getOwner() {
			return owner;
		}





		public void setOwner(User owner) {
			this.owner = owner;
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





		public Book() {
			
		}
		
		
		
		@PrePersist
	     protected void onCreate(){
	         this.createdAt = new Date();
	     }
	     @PreUpdate
	     protected void onUpdate(){
	         this.updatedAt = new Date();
	     }
	     
		
}
