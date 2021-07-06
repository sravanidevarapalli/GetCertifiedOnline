package com.GetCertifiedOnline.Controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GetCertifiedOnline.Entity.Certification;
import com.GetCertifiedOnline.Exception.CertificationNotFoundException;
import com.GetCertifiedOnline.Service.CertificationService;


@CrossOrigin("*")
@RestController()
@RequestMapping("/certification")
@Validated
public class CertificationController {
	private static final Logger logger = LoggerFactory.getLogger(CertificationController.class);
	@Autowired
	CertificationService certificationservice;
	
	@PostMapping("/addcertification")
	public Certification addCertification(@Valid @RequestBody Certification c){
		logger.info("Certification is added");
		return certificationservice.addcertification(c);
		
	}
	
	@PutMapping("/updatecertification")
	public Certification updateCertification(@Valid @RequestBody Certification c){
		logger.info("Certification is update");
		return certificationservice.updatecertification(c);
	}
	
	@GetMapping("/viewAllcertification")
	public List<Certification> viewAllCertification(){
		logger.info("view all the certification");
		return certificationservice.viewAllcertification();
	}
	
	@GetMapping(value="/viewcertificationbyid/{id}")
	public Certification viewcertificationById(@PathVariable Integer id) throws CertificationNotFoundException {
		logger.info("In Certification Controller to retrieve a Certification by Id ..>!!!");
		
		Certification c = null;
		try {
			logger.info("Certification Id to be searched...+id");
			c = certificationservice.viewcertificationById(id);
		}catch(Exception e) {
			throw new CertificationNotFoundException("Enter valid Certification id");
		}
		return c;
	}	
	
	@DeleteMapping(value="/deletecertification/{id}") 
	public Boolean deletecertification(@PathVariable Integer id) throws CertificationNotFoundException {
		logger.info("In Certification Controller to delete Certification by Id ..>!!!");
		
		try {
			logger.info("Certification Id to be deleted..."+id);
			
			certificationservice.viewcertificationById(id);
			
		}catch(Exception e) {
			logger.info("In catch block of DeleteCertificationById()...!");
			throw new CertificationNotFoundException("Enter existing id");
		}
		return certificationservice.deletecertificationById(id);
	}
	}
	
	
	
	
	
	
	
	


