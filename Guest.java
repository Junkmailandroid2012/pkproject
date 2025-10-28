package com.hospitality.management.entity;



import java.util.Date; // Use java.util.Date
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "guests")
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guestId;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String idProofType;
    private String idProofNumber;

    // New fields for Aadhaar data
    private String gender;
    private Date dateOfBirth;
    private String city;
    private String district;
    private String state;
    private String pinCode;
    private String aadhaarNumber;

    @CreationTimestamp
    private Date createdAt; // Changed to java.util.Date

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIdProofType() {
        return idProofType;
    }

    public void setIdProofType(String idProofType) {
        this.idProofType = idProofType;
    }

    public String getIdProofNumber() {
        return idProofNumber;
    }

    public void setIdProofNumber(String idProofNumber) {
        this.idProofNumber = idProofNumber;
    }

    public Date getCreatedAt() { // Changed to Date
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) { // Changed to Date
        this.createdAt = createdAt;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() { // Already using Date
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) { // Already using Date
        this.dateOfBirth = dateOfBirth;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

	public Guest(Long guestId, String firstName, String lastName, String email, String phone, String address,
			String idProofType, String idProofNumber, String gender, Date dateOfBirth, String city, String district,
			String state, String pinCode, String aadhaarNumber, Date createdAt) {
		super();
		this.guestId = guestId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.idProofType = idProofType;
		this.idProofNumber = idProofNumber;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.city = city;
		this.district = district;
		this.state = state;
		this.pinCode = pinCode;
		this.aadhaarNumber = aadhaarNumber;
		this.createdAt = createdAt;
	}

	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}

    
}
