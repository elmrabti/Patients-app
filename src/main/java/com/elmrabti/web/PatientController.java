package com.elmrabti.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.elmrabti.entities.Patient;
import com.elmrabti.repositories.PatientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PatientController {
	
	private PatientRepository patientRepository ;
	
	@GetMapping(path = "/index")
	public String patients(Model model) {
		List<Patient> patients = patientRepository.findAll() ;
		model.addAttribute("listePatients", patients) ;
		return "patients";
	}

}
