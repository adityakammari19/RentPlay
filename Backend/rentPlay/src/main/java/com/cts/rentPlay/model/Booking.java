package com.cts.rentPlay.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
////	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL, optional = true)
//	@JoinColumn(name = "playground_id",nullable = false)
//	private Playground playground;
	
//	@ManyToOne
	private Long playgroundId;
	
//	@ManyToOne
//	@JoinColumn(name = "user_id",nullable = false)
//	private User user;
	
	private Long userId;
	
	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime startTime;
	
	@Column(nullable = false)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private LocalDateTime endTime;
	
	@Column(nullable = false)
	private String status;
	
	@Column(nullable = false)
	private double totalPrice;

	

	
	
}
