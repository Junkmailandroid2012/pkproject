package com.hospitality.management.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

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

//ServiceUsage.java
@Entity
@Table(name = "service_usage")
public class ServiceUsage {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long usageId;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "check_in_id", nullable = false)
 private CheckIn checkIn;
 
 @ManyToOne(fetch = FetchType.LAZY)
 @JoinColumn(name = "service_id", nullable = false)
 private HotalServices service;
 
 @Column(nullable = false)
 private Integer quantity = 1;
 
 @Column(name = "unit_price", nullable = false, precision = 10, scale = 2)
 private BigDecimal unitPrice;
 
 @Column(name = "total_price", nullable = false, precision = 10, scale = 2)
 private BigDecimal totalPrice;
 
 @CreationTimestamp
 @Column(name = "usage_date")
 private Timestamp usageDate;
 
 @Column(name = "notes")
 private String notes;
 
 // Constructors
 public ServiceUsage() {}
 
 public ServiceUsage(CheckIn checkIn, HotalServices service, Integer quantity, String notes) {
     this.checkIn = checkIn;
     this.service = service;
     this.quantity = quantity;
     this.unitPrice = service.getPrice();
     this.totalPrice = service.getPrice().multiply(BigDecimal.valueOf(quantity));
     this.notes = notes;
 }
 
 // PrePersist method to calculate total price
 @PrePersist
 @PreUpdate
 public void calculateTotalPrice() {
     if (unitPrice != null && quantity != null) {
         this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
     }
 }
 
// @PrePersist
// @PreUpdate
// public void validate() {
//     if (quantity == null || quantity <= 0) {
//         throw new IllegalArgumentException("Quantity must be greater than 0");
//     }
//     if (unitPrice == null || unitPrice.compareTo(BigDecimal.ZERO) < 0) {
//         throw new IllegalArgumentException("Unit price must be non-negative");
//     }
//     if (totalPrice == null || totalPrice.compareTo(BigDecimal.ZERO) < 0) {
//         throw new IllegalArgumentException("Total price must be non-negative");
//     }
//     if (checkIn == null) {
//         throw new IllegalArgumentException("Check-in must be specified");
//     }
//     if (service == null) {
//         throw new IllegalArgumentException("Service must be specified");
//     }
//     
//     // Auto-calculate total price if not set correctly
//     if (totalPrice.compareTo(unitPrice.multiply(BigDecimal.valueOf(quantity))) != 0) {
//         this.totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
//     }
// }
 // Getters and Setters
 public Long getUsageId() {
     return usageId;
 }
 
 public void setUsageId(Long usageId) {
     this.usageId = usageId;
 }
 
 public CheckIn getCheckIn() {
     return checkIn;
 }
 
 public void setCheckIn(CheckIn checkIn) {
     this.checkIn = checkIn;
 }
 
 public HotalServices getService() {
     return service;
 }
 
 public void setService(HotalServices service) {
     this.service = service;
     if (service != null && this.unitPrice == null) {
         this.unitPrice = service.getPrice();
     }
 }
 
 public Integer getQuantity() {
     return quantity;
 }
 
 public void setQuantity(Integer quantity) {
     this.quantity = quantity;
     calculateTotalPrice();
 }
 
 public BigDecimal getUnitPrice() {
     return unitPrice;
 }
 
 public void setUnitPrice(BigDecimal unitPrice) {
     this.unitPrice = unitPrice;
     calculateTotalPrice();
 }
 
 public BigDecimal getTotalPrice() {
     return totalPrice;
 }
 
 public void setTotalPrice(BigDecimal totalPrice) {
     this.totalPrice = totalPrice;
 }
 
 public Timestamp getUsageDate() {
     return usageDate;
 }
 
 public void setUsageDate(Timestamp usageDate) {
     this.usageDate = usageDate;
 }
 
 public String getNotes() {
     return notes;
 }
 
 public void setNotes(String notes) {
     this.notes = notes;
 }

public ServiceUsage(Long usageId, CheckIn checkIn, HotalServices service, Integer quantity, BigDecimal unitPrice,
		BigDecimal totalPrice, Timestamp usageDate, String notes) {
	super();
	this.usageId = usageId;
	this.checkIn = checkIn;
	this.service = service;
	this.quantity = quantity;
	this.unitPrice = unitPrice;
	this.totalPrice = totalPrice;
	this.usageDate = usageDate;
	this.notes = notes;
}

@Override
public String toString() {
	return "ServiceUsage [usageId=" + usageId + ", checkIn=" + checkIn + ", service=" + service + ", quantity="
			+ quantity + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", usageDate=" + usageDate
			+ ", notes=" + notes + "]";
}
 
}