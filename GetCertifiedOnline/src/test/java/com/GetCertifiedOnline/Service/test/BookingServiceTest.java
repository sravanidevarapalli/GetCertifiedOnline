package com.GetCertifiedOnline.Service.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertSame;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.GetCertifiedOnline.Entity.Booking;
import com.GetCertifiedOnline.Repository.BookingDao;
import com.GetCertifiedOnline.Service.BookingService;


@RunWith(SpringRunner.class)
@SpringBootTest
class BookingServiceTest {
	
	@Autowired
	private BookingService bookingService;
	
	@MockBean
	private BookingDao bookingDao;
	
	@Test
	public void testBookingCertification() {
		String date=LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
		Booking booking=new Booking();
		booking.setBooking_Id(201);
		booking.setDate(date);
		booking.setCertificate_Id(102);
		booking.setCourse_Id(301);
		booking.setUser_Id(111);
		Mockito.when(bookingDao.save(booking)).thenReturn(booking);
		assertThat(bookingService.bookingCertification(booking)).isEqualTo(booking);
	}

	@Test
	public void listOfBooking() {
		String date=LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
		Booking booking1=new Booking();
		booking1.setBooking_Id(201);
		booking1.setDate(date);
		booking1.setCertificate_Id(102);
		booking1.setCourse_Id(301);
		booking1.setUser_Id(111);
		
		Booking booking2=new Booking();
		booking2.setBooking_Id(202);
		booking2.setDate(date);
		booking2.setCertificate_Id(102);
		booking2.setCourse_Id(301);
		booking2.setUser_Id(111);
		
		List<Booking> listofBooking=new ArrayList<Booking>();
		listofBooking.add(booking1);
		listofBooking.add(booking2);
		
		Mockito.when(bookingDao.findAll()).thenReturn(listofBooking);
		assertThat(bookingService.listOfBooking()).isEqualTo(listofBooking);
	}
	
	@Test
	public void deleteBooking() {
		String date=LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
		Booking booking1=new Booking();
		booking1.setBooking_Id(201);
		booking1.setDate(date);
		booking1.setCertificate_Id(102);
		booking1.setCourse_Id(301);
		booking1.setUser_Id(111);
		Mockito.when(bookingDao.existsById(booking1.getBookingId())).thenReturn(true);
		assertSame(bookingDao.existsById(booking1.getBookingId()),true);
	}
}
