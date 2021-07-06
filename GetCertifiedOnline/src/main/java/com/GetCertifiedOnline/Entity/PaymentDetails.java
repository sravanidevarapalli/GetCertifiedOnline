package com.GetCertifiedOnline.Entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name = "paymentms")
public class PaymentDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer payment_Id;
	
	private Integer bookingId;
	


	@DecimalMin("100")
	private Integer amount;
	
	@Size(min = 13, max = 19, message = "CardNumnber must be between 13 and 19 numbers")
	private String cardNumber;
	
	@Size(min = 2, max = 30, message = "CardHolderName must be between 1 and 30 characters")
    private String cardHolderName;
	
	@NotNull(message = "Not null")
	private String cardExpiryDate;
	
	@NotNull(message = "Not null")
	private String paymentMode;
	 
	
	public PaymentDetails() {
		
	}


	public Integer getPayment_Id() {
		return payment_Id;
	}


	public void setPayment_Id(Integer payment_Id) {
		this.payment_Id = payment_Id;
	}

	public Integer getBookingId() {
		return bookingId;
	}


	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	public Integer getAmount() {
		return amount;
	}


	public void setAmount(Integer amount) {
		this.amount = amount;
	}


	public  String getCardNumber() {
		return cardNumber;
	}


	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}


	public String getCardHolderName() {
		return cardHolderName;
	}


	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}


	public String getCardExpiryDate() {
		return cardExpiryDate;
	}


	public void setCardExpiryDate(String cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}


	public String getPaymentMode() {
		return paymentMode;
	}


	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

  


public PaymentDetails(Integer payment_Id, Integer bookingId, @DecimalMin("100") Integer amount,
			@Size(min = 13, max = 19, message = "CardNumnber must be between 13 and 19 numbers") String cardNumber,
			@Size(min = 2, max = 30, message = "CardHolderName must be between 1 and 30 characters") String cardHolderName,
			@NotNull(message = "Not null") String cardExpiryDate,
			@NotNull(message = "Not null") String paymentMode) {
		super();
		this.payment_Id = payment_Id;
		this.bookingId = bookingId;
		this.amount = amount;
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.cardExpiryDate = cardExpiryDate;
		this.paymentMode = paymentMode;
	}


@Override
public String toString() {
	return "PaymentDetails [payment_Id=" + payment_Id + ", bookingId=" + bookingId + ", amount=" + amount
			+ ", cardNumber=" + cardNumber + ", cardHolderName=" + cardHolderName + ", cardExpiryDate=" + cardExpiryDate
			+ ", paymentMode=" + paymentMode + "]";
}


	


	
}