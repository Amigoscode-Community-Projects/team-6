package com.appointmentmanager.eappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appointmentmanager.eappointment.entity.DoctorProfileEntity;

@Repository
public interface DoctorProfileRepository extends JpaRepository<DoctorProfileEntity, Long> {

}
