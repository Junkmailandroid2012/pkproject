package com.hospitality.management.entity;

import java.math.BigDecimal;
//import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

//Billing.java
@Entity
@Table(name = "billings")
public class Billing {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long billingId;
 
 @ManyToOne
 @JoinColumn(name = "check_in_id")
 private CheckIn checkIn;
 
 private BigDecimal totalAmount;
 private BigDecimal taxAmount;
 private BigDecimal discountAmount;
 private BigDecimal finalAmount;
 private String paymentStatus;
 private String paymentMethod;
 private Date paymentDate;
 
 @CreationTimestamp
 private Date createdAt;

public Long getBillingId() {
	return billingId;
}

public void setBillingId(Long billingId) {
	this.billingId = billingId;
}

public CheckIn getCheckIn() {
	return checkIn;
}

public void setCheckIn(CheckIn checkIn) {
	this.checkIn = checkIn;
}

public BigDecimal getTotalAmount() {
	return totalAmount;
}

public void setTotalAmount(BigDecimal totalAmount) {
	this.totalAmount = totalAmount;
}

public BigDecimal getTaxAmount() {
	return taxAmount;
}

public void setTaxAmount(BigDecimal taxAmount) {
	this.taxAmount = taxAmount;
}

public BigDecimal getDiscountAmount() {
	return discountAmount;
}

public void setDiscountAmount(BigDecimal discountAmount) {
	this.discountAmount = discountAmount;
}

public BigDecimal getFinalAmount() {
	return finalAmount;
}

public void setFinalAmount(BigDecimal finalAmount) {
	this.finalAmount = finalAmount;
}

public String getPaymentStatus() {
	return paymentStatus;
}

public void setPaymentStatus(String paymentStatus) {
	this.paymentStatus = paymentStatus;
}

public String getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}

public Date getPaymentDate() {
	return paymentDate;
}

public void setPaymentDate(Date paymentDate) {
	this.paymentDate = paymentDate;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date date) {
	this.createdAt = date;
}
 
 // Constructors, getters, setters
}

