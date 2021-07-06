package com.GetCertifiedOnline.Service;

import java.util.List;

import com.GetCertifiedOnline.Entity.Booking;



public interface BookingService {

	/**
	 * This method is used to do booking of certification exam and it takes 
	 * the booking object as argument and pass that to Dao layer to saved to the database.
	 * @param booking
	 * @return
	 */
	Booking bookingCertification(Booking booking);
	
	/**
	 * This method is used to do booking of certification exam and it takes 
	 * the booking object as argument and pass that to Dao layer to saved to the database.
	 * @param booking
	 * @return
	 */
	Booking bookingCourse(Booking booking);
	
	/**
	 * This method is used to get list of booking made by the user
	 * for courses and certification.
	 * @return
	 */
	List<Booking> listOfBooking();
	
	/**
	 * This is used to delete the booking made for courses and certification
	 * by user.
	 * @param bookingId
	 * @return
	 */
	boolean deleteBooking(int bookingId);
	/**
	 * This method is used to get booking based on certificate id 
	 * and user id
	 * @param certificateId
	 * @param userId
	 * @return
	 */
	Booking getBookingByCertificateIdAndUserId(int certificateId,int userId);
	/**
	 *This method is used to get booking based on course id 
	 * and user id
	 * @param courseId
	 * @param userId
	 * @return
	 */
	Booking getBookingByCourseIdAndUserId(int courseId,int userId);

}
