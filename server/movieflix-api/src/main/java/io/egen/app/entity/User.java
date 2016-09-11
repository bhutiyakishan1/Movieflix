package io.egen.app.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity
@Table

@NamedQueries({
		@NamedQuery(name="User.findAll" , query="Select e from User e ORDER BY e.email"),
			  @NamedQuery(name="User.findByEmail" , query ="Select e from User e where e.email = :pEmail")
			  })

public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String email;
	
	private String role;
	
	
	public User(){
		id= UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", role=" + role + "]";
	}
	
	
}
