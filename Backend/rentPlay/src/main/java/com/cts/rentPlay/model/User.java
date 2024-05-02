package com.cts.rentPlay.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")  
	private Long userId;
	
	@NotEmpty(message = "firstName Must not be empty")
    @Column(name = "first_name") 
	private String firstName;
	
	@Column(name = "last_name") 
	private String lastName;
	
	@NotNull
    @Size(min = 3, max = 20 ,message ="Username should have to be atleast 3 and atmost 20 characters")
    @Column(name = "username", unique = true)  
	private String username;
	
	@Email(message = "Must be a well-formed email address")
    @Column(name = "email", unique = true) 
	private String email;
	
	@Size(min=5, message="Password should contain atleast 5 characters")
    @Column(name = "password") 
	private String password;
	
	 @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	 @Column(name = "phone_number") 
	private String phoneNumber;
	
	@Column(name = "is_enabled")  
    private boolean isEnabled; 

	
	 @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	    @JoinTable(
	            name = "users_roles",
	            joinColumns = @JoinColumn(name = "user_id"),
	            inverseJoinColumns = @JoinColumn(name = "role_id")
	            )
	    private Set<Role> roles = new HashSet<>();

}
