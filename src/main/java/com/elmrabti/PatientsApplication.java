package com.elmrabti;
import com.elmrabti.entities.Patient;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.elmrabti.entities.Patient;
import com.elmrabti.repositories.PatientRepository;

@SpringBootApplication
public class PatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}
	
	@Bean
	CommandLineRunner commandLineRunner(PatientRepository patientRepository) {
		return args -> {
			patientRepository.save(new Patient(null, "Hamza", new Date() , false, 23) ) ;
			patientRepository.save(new Patient(null, "Zineb", new Date() , true, 181) ) ;
			patientRepository.save(new Patient(null, "Brahim", new Date() , true, 45) ) ;
			patientRepository.save(new Patient(null, "Amina", new Date() , false, 96) ) ;
			
			patientRepository.findAll().forEach(p->{
				System.out.println(p.getNom());
			});
			
		};
	}

}






