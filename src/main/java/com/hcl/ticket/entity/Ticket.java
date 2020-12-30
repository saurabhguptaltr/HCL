package com.hcl.ticket.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_TICKET")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_id")
	private Long ticketId;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "status")
	private String status;

	@Column(name = "train_id")
	private Long trainId;

	@Column(name = "number_of_ticket")
	private int numberOfTicket;

	@Column(name = "ticket_booking_date")
	private Date bookingDate;

	@Column(name = "travelling_date")
	private Date travellingDate;

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public int getNumberOfTicket() {
		return numberOfTicket;
	}

	public void setNumberOfTicket(int numberOfTicket) {
		this.numberOfTicket = numberOfTicket;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getTravellingDate() {
		return travellingDate;
	}

	public void setTravellingDate(Date travellingDate) {
		this.travellingDate = travellingDate;
	}

	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", userId=" + userId + ", status=" + status + ", trainId=" + trainId
				+ ", numberOfTicket=" + numberOfTicket + ", bookingDate=" + bookingDate + ", travellingDate="
				+ travellingDate + "]";
	}

}