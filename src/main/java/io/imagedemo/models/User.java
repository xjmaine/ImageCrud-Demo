package io.imagedemo.models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;

@Entity
@Table(name = "users")
//@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_name")
	private String username;
	
	@Column(length =64)
//	@Getter(AccessLevel.PROTECTED)
	private String photos;
	
	public User() {}

	public Integer getId() {
		return id;
	}
	
	

	public User(Integer id, String username, String photos) {
		super();
		this.id = id;
		this.username = username;
		this.photos = photos;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public String getPhotos() {
		// TODO Auto-generated method stub
		return photos;
	}
	
//	getters and setters

}
