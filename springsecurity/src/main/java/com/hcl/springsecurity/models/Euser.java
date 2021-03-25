package com.hcl.springsecurity.models;

import javax.persistence.*;

@Entity
@Table(name = "esecurity")
public class Euser {
	
	   @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Integer id;
	    
	    @Column(name="firstname")
	    private String firstName;
	    
	    @Column(name="lastname")
	    private String lastName;
	   
	    @Column(name="username")
		private String username;
	    
	    @Column(name="active")
	    private boolean active;
	    
	    @Column(name="password")
		private String password;
	    
	    @Column(name="roles")
	    private String roles;
	    
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

		public String getRoles() {
			return roles;
		}

		public void setRoles(String roles) {
			this.roles = roles;
		}

		public Integer getId() {
			return id;
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

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}
	    

}
