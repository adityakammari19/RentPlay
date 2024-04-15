package com.cts.rentPlay.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "playgrounds")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Playground {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long playgroundId;
	
	@Column(nullable = false)
	private String playgroundName;
	
	@Column(nullable = false)
	private String location;
	
	@Column(nullable = false)
	private Long ownerId;
	
	@Column(nullable = false)
	private String phoneNumber;
	
	@Column(nullable = false)
	private String amenities;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private double pricePerSlot;
	
	@Column(nullable = false)
	private int slotsAvailable;
	
	@Column(nullable = false)
	private String sportsAllowed;
	
	
	

}
