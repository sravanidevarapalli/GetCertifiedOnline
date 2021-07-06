package com.GetCertifiedOnline.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.GetCertifiedOnline.Entity.Booking;



public interface BookingDao extends JpaRepository<Booking,Integer> {
	
	/*
	 *This method fetch booking based on the certificate id and user id 
	 *
	 */
	Booking getBookingByCertificateIdAndUserId(int certificateId,int userId);
	
	/*
	 *This method fetch booking based on the course id and user id 
	 *
	 */
	Booking getBookingByCourseIdAndUserId(int courseId,int userId);
}
