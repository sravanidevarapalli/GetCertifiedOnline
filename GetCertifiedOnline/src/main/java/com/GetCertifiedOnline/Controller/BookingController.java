package com.GetCertifiedOnline.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GetCertifiedOnline.Entity.Booking;
import com.GetCertifiedOnline.Service.BookingService;
import com.GetCertifiedOnline.dto.Message;

/**
 * This class contains all api methods for Boooking Serivce.
 * 
 * @author ymadhuka
 *
 */
@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	/**
	 * This method is used to book certification exam and and it takes the booking
	 * object as argument and pass object to service layer method.
	 * 
	 * @param booking
	 * @return
	 */
	@PostMapping("/certification")
	public ResponseEntity<String> bookingCertificate(@RequestBody Booking booking) {
		Booking booked = bookingService.getBookingByCertificateIdAndUserId(booking.getCertificateId(),
				booking.getUserId());
		if (booked != null) {
			return new ResponseEntity<String>("You have already booked this certification", HttpStatus.OK);
		} else {
			Booking response = bookingService.bookingCertification(booking);
			if (response != null) {

				return new ResponseEntity<String>("Certification booked proceed to payment...", HttpStatus.OK);
			}
			return new ResponseEntity<String>("booking failed..", HttpStatus.NOT_FOUND);

		}

	}

	/**
	 * This method is used to book course and it takes the booking object as
	 * argument and pass object to service layer method.
	 * 
	 * @param booking
	 * @return
	 */
	@PostMapping("/course")
	public ResponseEntity<String> bookingCourse(@RequestBody Booking booking) {
		System.out.println(booking);
		Booking booked = bookingService.getBookingByCourseIdAndUserId(booking.getCourseId(), booking.getUserId());
		if (booked != null) {
			return new ResponseEntity<String>("You have already booked this Course", HttpStatus.OK);
		} else {
			Booking response = bookingService.bookingCourse(booking);
			if (response != null) {
				return new ResponseEntity<String>("Course booked proceed to payment...", HttpStatus.OK);
			}
			return new ResponseEntity<String>("booking failed..", HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * This method is used to get list of booking made by the user for courses and
	 * certification.
	 * 
	 * @return
	 */
	@GetMapping("/bookinglist")
	public ResponseEntity<Message> listOfBooking() {
		List<Booking> bookingList = bookingService.listOfBooking();
		Message msg = new Message();
		if (bookingList.isEmpty()) {
			msg.setResMessage("No Booking Found..");
			return null;
		}
		msg.setResMessage("Successfully feteched");
		msg.setBookingList(bookingList);
		return new ResponseEntity<Message>(msg, HttpStatus.OK);
	}

	/**
	 * This method is used to delete the booking based on the booking_id.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBooking(@PathVariable("id") int id) {
		boolean delete = bookingService.deleteBooking(id);
		if (delete) {
			return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>("No result found.", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/certificate/{certificateid}/{userid}")
	public ResponseEntity<Booking> getCertificateBooking(@PathVariable("certificateid") int certificateId,
			@PathVariable("userid") int userId) {
		Booking booking = bookingService.getBookingByCertificateIdAndUserId(certificateId, userId);
		if (booking != null) {
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		}
		return null;
	}

	@GetMapping("/course/{courseid}/{userid}")
	public ResponseEntity<Booking> getCourseBooking(@PathVariable("courseid") int courseId,
			@PathVariable("userid") int userId) {
		Booking booking = bookingService.getBookingByCourseIdAndUserId(courseId, userId);
		if (booking != null) {
			return new ResponseEntity<Booking>(booking, HttpStatus.OK);
		}
		return null;
	}
}
