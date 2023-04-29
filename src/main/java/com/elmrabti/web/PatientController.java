package com.elmrabti.web;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.elmrabti.entities.Patient;
import com.elmrabti.repositories.PatientRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class PatientController {
	
	private PatientRepository patientRepository ;
	
	@GetMapping(path = "/index")
	public String patients(Model model,
						   @RequestParam(name = "page", defaultValue = "0" ) int page, 
						   @RequestParam(name = "size", defaultValue = "6" ) int size,
						   @RequestParam(name = "keyword", defaultValue = "") String keyword) {
		Page<Patient> pagePatients = patientRepository.findByNomContains(keyword, PageRequest.of(page, size)) ;
		model.addAttribute("listePatients", pagePatients.getContent()) ;
		model.addAttribute("pages", new int[pagePatients.getTotalPages()] ) ;
		model.addAttribute("currentPage",page) ;
		model.addAttribute("keyword",keyword) ;
		return "patients";
	}
	
	@GetMapping(path = "/delete")
	public String delete(Long id, String keyword, int page) {
		patientRepository.deleteById(id);
		return "redirect:index?page="+page+"&keyword="+keyword;
	}
	
	@GetMapping(path = "/")
	public String home() {
		return "redirect:index";
	}
	
	@GetMapping(path = "/patients")
	@ResponseBody
	public List<Patient> listePatients() {
		return patientRepository.findAll() ;
	}	
	
	@GetMapping(path = "/formPatients")
	public String formPatients() {
		return "formPatients";
	}
	
	
	

}
