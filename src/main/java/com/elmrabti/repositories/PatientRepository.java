package com.elmrabti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elmrabti.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
	
	

}
