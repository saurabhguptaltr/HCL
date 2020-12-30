package com.hcl.payment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_PAYMENT")
public class PaymentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Long paymentId;

	@Column(name = "insurance_id")
	private Long insuranceId;

	@Column(name = "ticket_id")
	private Long ticketId;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "status")
	private String status;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

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

	@Override
	public String toString() {
		return "PaymentEntity [paymentId=" + paymentId + ", insuranceId=" + insuranceId + ", ticketId=" + ticketId
				+ ", totalPrice=" + totalPrice + ", status=" + status + "]";
	}

	public PaymentEntity(Long paymentId, Long insuranceId, Long ticketId, double totalPrice, String status) {
		super();
		this.paymentId = paymentId;
		this.insuranceId = insuranceId;
		this.ticketId = ticketId;
		this.totalPrice = totalPrice;
		this.status = status;
	}

	public PaymentEntity() {
		super();
	}

}