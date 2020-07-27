package com.appointmentmanager.eappointment.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentmanager.eappointment.dto.DoctorProfile;
import com.appointmentmanager.eappointment.entity.DoctorProfileEntity;
import com.appointmentmanager.eappointment.repository.DoctorProfileRepository;
import com.appointmentmanager.eappointment.service.DoctorProfileService;

@Service
public class DoctorProfileServiceImpl implements DoctorProfileService {
	@Autowired DoctorProfileRepository doctorProfileRepository;
	
	//save the doctor profile to database
	@Override
	public void saveDoctorProfile(DoctorProfile doctorProfile) {
		DoctorProfileEntity doctorProfileEntity=new DoctorProfileEntity();
		BeanUtils.copyProperties(doctorProfile, doctorProfileEntity);
		doctorProfileRepository.save(doctorProfileEntity);
		
	}
	//fetch all doctor information from database
	@Override
	public List<DoctorProfile> findAllDoctors() {
		List<DoctorProfileEntity> allDoctorProfileEntity=doctorProfileRepository.findAll();
		List<DoctorProfile> allDoctorsProfile=new ArrayList<>();
		
		if(allDoctorProfileEntity!=null) {
			for(DoctorProfileEntity tempEntity:allDoctorProfileEntity) {
				DoctorProfile doctorProfileSingle=new DoctorProfile();
				BeanUtils.copyProperties(tempEntity,doctorProfileSingle);
				allDoctorsProfile.add(doctorProfileSingle);
			}
			return allDoctorsProfile;
		}else {
				return Collections.emptyList();
			}
		
	}

	
	//edit/update doctors profile
	
	@Override
	public void updateDoctorProfile(DoctorProfile doctorProfile) {
		DoctorProfileEntity oldDoctorProfileEntity=doctorProfileRepository.findById(doctorProfile.getProfileId()).get();
		
		oldDoctorProfileEntity.setDoctorName(doctorProfile.getDoctorName());
		oldDoctorProfileEntity.setDesignation(doctorProfile.getDesignation());
		oldDoctorProfileEntity.setGender(doctorProfile.getGender());
		oldDoctorProfileEntity.setPersonalAddress(doctorProfile.getPersonalAddress());
		oldDoctorProfileEntity.setMeetingAddress(doctorProfile.getMeetingAddress());
		oldDoctorProfileEntity.setMail(doctorProfile.getMail());		
		oldDoctorProfileEntity.setContact(doctorProfile.getContact());
		oldDoctorProfileEntity.setStatus(doctorProfile.getStatus());
		oldDoctorProfileEntity.setImage(doctorProfile.getImage());
		
		System.out.println("before update save"+oldDoctorProfileEntity);
		doctorProfileRepository.save(oldDoctorProfileEntity);
		
		
	}
	
	
	
}
