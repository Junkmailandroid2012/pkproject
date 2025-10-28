package com.hospitality.management.entity;




import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//CheckIn.java
@Entity
@Table(name = "check_ins")
public class CheckIn {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long checkInId;
 
 @ManyToOne
 @JoinColumn(name = "guest_id")
 private Guest guest;
 
 @OneToMany(mappedBy = "checkIn", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
 private List<ServiceUsage> serviceUsages = new ArrayList<>();
 
 @ManyToOne
 @JoinColumn(name = "room_id")
 private Room room;
 
 @CreationTimestamp
 private Date checkInDate;
 
 private Date expectedCheckOut;
 private Date actualCheckOut;
 private Integer adultsCount;
 private Integer childrenCount;
 private String specialRequests;
 private String status;
 
 
 // Getters and setters
 public List<ServiceUsage> getServiceUsages() {
     return serviceUsages;
 }
 
 public void setServiceUsages(List<ServiceUsage> serviceUsages) {
     this.serviceUsages = serviceUsages;
 }
 
 
 
public Long getCheckInId() {
	return checkInId;
}
public void setCheckInId(Long checkInId) {
	this.checkInId = checkInId;
}
public Guest getGuest() {
	return guest;
}
public void setGuest(Guest guest) {
	this.guest = guest;
}
public Room getRoom() {
	return room;
}
public void setRoom(Room room) {
	this.room = room;
}
public Date getCheckInDate() {
	return checkInDate;
}
public void setCheckInDate(Date checkInDate) {
	this.checkInDate = checkInDate;
}
public Date getExpectedCheckOut() {
	return expectedCheckOut;
}
public void setExpectedCheckOut(Date expectedCheckOut) {
	this.expectedCheckOut = expectedCheckOut;
}
public Date getActualCheckOut() {
	return actualCheckOut;
}
public void setActualCheckOut(java.util.Date date) {
	this.actualCheckOut = date;
}
public Integer getAdultsCount() {
	return adultsCount;
}
public void setAdultsCount(Integer adultsCount) {
	this.adultsCount = adultsCount;
}
public Integer getChildrenCount() {
	return childrenCount;
}
public void setChildrenCount(Integer childrenCount) {
	this.childrenCount = childrenCount;
}
public String getSpecialRequests() {
	return specialRequests;
}
public void setSpecialRequests(String specialRequests) {
	this.specialRequests = specialRequests;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public CheckIn() {
	super();
	// TODO Auto-generated constructor stub
}
public CheckIn(Long checkInId, Guest guest, Room room, Date checkInDate, Date expectedCheckOut,
		Date actualCheckOut, Integer adultsCount, Integer childrenCount, String specialRequests, String status) {
	super();
	this.checkInId = checkInId;
	this.guest = guest;
	this.room = room;
	this.checkInDate = checkInDate;
	this.expectedCheckOut = expectedCheckOut;
	this.actualCheckOut = actualCheckOut;
	this.adultsCount = adultsCount;
	this.childrenCount = childrenCount;
	this.specialRequests = specialRequests;
	this.status = status;
}
 
 // Constructors, getters, setters
 
}
