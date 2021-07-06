package com.GetCertifiedOnline.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GetCertifiedOnline.Entity.Certification;
import com.GetCertifiedOnline.Repository.CertificationDao;



@Service
public class CertificationServiceImpl implements CertificationService {


	@Autowired
	CertificationDao certificationdao;
	
	@Override
	public Certification addcertification(Certification c) {
		certificationdao.saveAndFlush(c);
		return c;
	}

	@Override
	public Certification updatecertification(Certification c) {
		certificationdao.saveAndFlush(c);
		return c;
	}

	@Override
	public List<Certification> viewAllcertification() {
		return certificationdao.findAll();
	}

	
	public Boolean deletecertificationById(Integer id) {
		certificationdao.deleteById(id);
		return true;
	}

	
	public Certification viewcertificationById(Integer id) {
		Optional<Certification> certification = certificationdao.findById(id);
		return certification.get();
	}

	
	}
	


