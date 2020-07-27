package com.appointmentmanager.eappointment.service;

import java.util.List;

import com.appointmentmanager.eappointment.dto.DoctorProfile;

public interface DoctorProfileService {
	public void saveDoctorProfile(DoctorProfile doctorProfile);
	List<DoctorProfile> findAllDoctors();	
	public void updateDoctorProfile(DoctorProfile doctorProfile);
}
