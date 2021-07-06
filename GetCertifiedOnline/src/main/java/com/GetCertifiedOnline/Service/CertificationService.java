package com.GetCertifiedOnline.Service;

import java.util.List;

import com.GetCertifiedOnline.Entity.Certification;


public interface CertificationService {
	public Certification addcertification(Certification c);
	public Certification updatecertification(Certification c);
    public List<Certification> viewAllcertification();
    public Boolean deletecertificationById(Integer id);
    public Certification viewcertificationById(Integer id);
	
}

	
	
	
