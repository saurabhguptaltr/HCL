package com.hcl.payment.component;

import java.util.Optional;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.hcl.payment.entity.InsuranceEntity;
import com.hcl.payment.entity.PaymentEntity;
import com.hcl.payment.repo.InsuranceRepository;
import com.hcl.payment.repo.PaymentRepository;
import com.hcl.payment.repo.TicketRepository;
import com.hcl.payment.repo.TrainRepository;

@Component
public class PaymentComponent {

	@Autowired
	JmsTemplate jmstemplate;

	@Autowired
	private Queue queue;

	@Autowired
	TicketRepository ticketRepo;

	@Autowired
	TrainRepository trainRepo;

	@Autowired
	InsuranceRepository insuranceRepo;

	@Autowired
	PaymentRepository paymentRepo;

	@JmsListener(destination = "payment-queue")
	public void consume(Long insuranceId) throws InterruptedException {

		try {
			System.out.println("***In Payment** " + insuranceId);
			Optional<InsuranceEntity> insurenceOpt = insuranceRepo.findById(insuranceId);
			if (insurenceOpt.isPresent()) {
				InsuranceEntity insurance = insurenceOpt.get();
				PaymentEntity paymentEntity = new PaymentEntity(0L, insuranceId, insurance.getTicketId(),
						insurance.getTotalPrice(), "PAYMENT-SUCCESS");
				PaymentEntity updated = paymentRepo.save(paymentEntity);
				Thread.sleep(2000);
				System.out.println("payment after saving: " + updated);
				jmstemplate.convertAndSend(queue, updated.getPaymentId().toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
