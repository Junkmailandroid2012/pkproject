package com.hospitality.management.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//Service.java
@Entity
@Table(name = "services")
public class HotalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceId;
    
    @Column(name = "service_name", nullable = false)
    private String serviceName;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "service_type", nullable = false)
    private ServiceType serviceType;
    
    @Column(name = "price", nullable = false)
    private BigDecimal price;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "is_active")
    private Boolean isActive = true;
    
    @CreationTimestamp
    @Column(name = "created_at")
    private Timestamp createdAt;
    
    // Enum for service types - USE UPPERCASE
    public enum ServiceType {
        FOOD,       // UPPERCASE
        LAUNDRY,    // UPPERCASE  
        SPA,        // UPPERCASE
        TRANSPORT,  // UPPERCASE
        OTHER       // UPPERCASE
    }
    
    // Constructors
    public HotalServices() {}
    
    public HotalServices(String serviceName, ServiceType serviceType, BigDecimal price, String description) {
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.price = price;
        this.description = description;
    }
    
    // Getters and Setters
    public Long getServiceId() { return serviceId; }
    public void setServiceId(Long serviceId) { this.serviceId = serviceId; }
    
    public String getServiceName() { return serviceName; }
    public void setServiceName(String serviceName) { this.serviceName = serviceName; }
    
    public ServiceType getServiceType() { return serviceType; }
    public void setServiceType(ServiceType serviceType) { this.serviceType = serviceType; }
    
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

	@Override
	public String toString() {
		return "HotalServices [serviceId=" + serviceId + ", serviceName=" + serviceName + ", serviceType=" + serviceType
				+ ", price=" + price + ", description=" + description + ", isActive=" + isActive + ", createdAt="
				+ createdAt + "]";
	}
    
}