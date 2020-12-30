package com.hcl.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_INSURANCE")
public class InsuranceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "insurance_id")
	private Long insuranceId;

	@Column(name = "ticket_id")
	private Long ticketId;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "status")
	private String status;

	@Column(name = "insurance_amount")
	private double insuranceAmount;

	public Long getInsuranceId() {
		return insuranceId;
	}

	public void setInsuranceId(Long insuranceId) {
		this.insuranceId = insuranceId;
	}

	public Long getTicketId() {
		return ticketId;
	}

	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getInsuranceAmount() {
		return insuranceAmount;
	}

	public void setInsuranceAmount(double insuranceAmount) {
		this.insuranceAmount = insuranceAmount;
	}

	@Override
	public String toString() {
		return "InsuranceEntity [insuranceId=" + insuranceId + ", ticketId=" + ticketId + ", totalPrice=" + totalPrice
				+ ", status=" + status + ", insuranceAmount=" + insuranceAmount + "]";
	}

	public InsuranceEntity(Long insuranceId, Long ticketId, double totalPrice, String status, double insuranceAmount) {
		super();
		this.insuranceId = insuranceId;
		this.ticketId = ticketId;
		this.totalPrice = totalPrice;
		this.status = status;
		this.insuranceAmount = insuranceAmount;
	}

	public InsuranceEntity() {
		super();
	}

}