package com.GetCertifiedOnline.dto;

import java.util.List;

import com.GetCertifiedOnline.Entity.Booking;



public class Message {

	private String resMessage;
	
	private List<Booking> bookingList;

	public String getResMessage() {
		return resMessage;
	}

	public void setResMessage(String resMessage) {
		this.resMessage = resMessage;
	}

	public List<Booking> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<Booking> bookingList) {
		this.bookingList = bookingList;
	}

	@Override
	public String toString() {
		return "[Response=" + resMessage + ", booking=" + bookingList + "]";
	}
	
	
}
