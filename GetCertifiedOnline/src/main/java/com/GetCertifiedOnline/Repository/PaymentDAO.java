package com.GetCertifiedOnline.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GetCertifiedOnline.Entity.PaymentDetails;




@Repository
public interface PaymentDAO extends JpaRepository<PaymentDetails, Integer> {
	
}