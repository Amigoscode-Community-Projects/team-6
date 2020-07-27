package com.appointmentmanager.eappointment.controller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.appointmentmanager.eappointment.dto.DoctorProfile;

import com.appointmentmanager.eappointment.repository.DoctorProfileRepository;
import com.appointmentmanager.eappointment.service.DoctorProfileService;

@Controller
public class DoctorProfileController {
		private static final Logger logger = LoggerFactory.getLogger(DoctorProfileController.class);
		public static String uploadDirectory = System.getProperty("user.dir") + "\\uploads";
		@Autowired DoctorProfileService doctorProfileService;
		@Autowired DoctorProfileRepository doctorProfileRepository;
		
	 	@PostMapping("/doctorProfile")
	    public void createDoctorProfile(Model model, DoctorProfile doctorProfile, BindingResult result,
				@RequestParam("image_file") MultipartFile[] files) {
			logger.info("Errors: " + result.getAllErrors());{
	 	// store image in folder
			StringBuilder str_fileName = new StringBuilder();
			for (MultipartFile file : files) {
				
				if(file.getOriginalFilename().length()>0)
				{
					Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
					str_fileName.append(file.getOriginalFilename());
					try {
						logger.info("Directory: " + uploadDirectory);
						Files.write(fileNameAndPath, file.getBytes());
					} catch (IOException e) {
						logger.info("Exception: " + e);
					}
					doctorProfile.setImage(fileNameAndPath.toString());
				}
				
			}
	         doctorProfileService.saveDoctorProfile(doctorProfile);
	     }
	
	 	}
	 	
	   
	 	
}
