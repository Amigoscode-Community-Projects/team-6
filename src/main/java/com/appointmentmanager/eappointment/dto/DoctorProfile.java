package com.appointmentmanager.eappointment.dto;
import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class DoctorProfile {

//	personal information 
	private Long		profileId;
	
	@NotEmpty(message = "Name cannot be empty")
	@Pattern(regexp = "^[a-zA-Z]+(([. ][a-zA-Z ])?[a-zA-Z]*)*$", message = "Invalid format, Only alphabet and dot(.) character Allowed ")
	@Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters")
	private String		doctorName;
	
	private String		designation;
	
	private String		gender;
	
	private String		personalAddress;
	
	private String		meetingAddress;
	
	
	@Email(message = "Please provide valid email")
	private String		mail;
	
	@NotEmpty(message = "Primary Contact cannot be empty")
	@Pattern(regexp = "^01[3-9][0-9]{8}$", message="Invalid Contact No")
	private String		contact;
	
	private	String		status;
	
	private String 		image;//For image url
	
// appointment shedule 
	
	@NotEmpty(message="appointment Date and time cannot be empty, Please select a date and time")
	private String 			appointmentDateTimeString; 
	
	private Timestamp 		appointmentDateTime; 
	
	private String 			appointmentTime;

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPersonalAddress() {
		return personalAddress;
	}

	public void setPersonalAddress(String personalAddress) {
		this.personalAddress = personalAddress;
	}

	public String getMeetingAddress() {
		return meetingAddress;
	}

	public void setMeetingAddress(String meetingAddress) {
		this.meetingAddress = meetingAddress;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAppointmentDateTimeString() {
		return appointmentDateTimeString;
	}

	public void setAppointmentDateTimeString(String appointmentDateTimeString) {
		this.appointmentDateTimeString = appointmentDateTimeString;
	}

	public Timestamp getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(Timestamp appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public String getAppointmentTime() {
		return appointmentTime;
	}

	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}

	@Override
	public String toString() {
		return "DoctorProfile [profileId=" + profileId + ", doctorName=" + doctorName + ", designation=" + designation
				+ ", gender=" + gender + ", personalAddress=" + personalAddress + ", meetingAddress=" + meetingAddress
				+ ", mail=" + mail + ", contact=" + contact + ", status=" + status + ", image=" + image
				+ ", appointmentDateTimeString=" + appointmentDateTimeString + ", appointmentDateTime="
				+ appointmentDateTime + ", appointmentTime=" + appointmentTime + "]";
	}  
	
	
	
}
