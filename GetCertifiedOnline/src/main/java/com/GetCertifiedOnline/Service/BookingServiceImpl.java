package com.GetCertifiedOnline.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GetCertifiedOnline.Entity.Booking;
import com.GetCertifiedOnline.Repository.BookingDao;



@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	@Autowired
	private BookingDao bookingDao;

	@Override
	public Booking bookingCertification(Booking booking) {
		// TODO Auto-generated method stub
		booking.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
		return bookingDao.save(booking);

	}

	@Override
	public Booking bookingCourse(Booking booking) {
		// TODO Auto-generated method stub
		booking.setDate(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY")));
		return bookingDao.save(booking);
	}

	@Override
	public List<Booking> listOfBooking() {
		// TODO Auto-generated method stub
		return bookingDao.findAll();
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		// TODO Auto-generated method stub
		if (bookingDao.existsById(bookingId)) {
			bookingDao.deleteById(bookingId);
			return true;
		}
		return false;
	}

	@Override
	public Booking getBookingByCertificateIdAndUserId(int certificateId, int userId) {
		// TODO Auto-generated method stub
		return bookingDao.getBookingByCertificateIdAndUserId(certificateId, userId);
	}

	@Override
	public Booking getBookingByCourseIdAndUserId(int courseId, int userId) {
		// TODO Auto-generated method stub
		return bookingDao.getBookingByCourseIdAndUserId(courseId, userId);
	}


}
