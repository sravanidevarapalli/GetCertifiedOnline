package com.GetCertifiedOnline.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer bookingId;
	
	private String date;
	
	private Integer certificateId;
	
	private Integer courseId;
	
	private Integer userId;

	public Integer getBookingId() {
		return bookingId;
	}

	public void setBooking_Id(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCertificateId() {
		return certificateId;
	}

	public void setCertificate_Id(Integer certificateId) {
		this.certificateId = certificateId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourse_Id(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUser_Id(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", date=" + date + ", certificate_Id=" + certificateId
				+ ", courseId=" + courseId + ", userId=" + userId + "]";
	}

	
	
}
