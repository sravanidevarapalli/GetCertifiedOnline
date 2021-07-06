package com.GetCertifiedOnline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.GetCertifiedOnline.Entity.Certification;



@Repository
public interface CertificationDao extends JpaRepository<Certification, Integer>{

}
