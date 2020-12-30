package com.hcl.insurance.component;

import java.util.Optional;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.hcl.insurance.entity.InsuranceEntity;
import com.hcl.insurance.entity.Ticket;
import com.hcl.insurance.entity.Train;
import com.hcl.insurance.repo.InsuranceRepository;
import com.hcl.insurance.repo.TicketRepository;
import com.hcl.insurance.repo.TrainRepository;

@Component
public class InsuranceComponent {

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

	@JmsListener(destination = "insurance-queue")
	public void consume(Long ticketId) throws InterruptedException {
		try {
			Thread.sleep(1000);
			System.out.println("****** insurance *****: " + ticketId.toString());
			Optional<Ticket> ticket = ticketRepo.findById(ticketId);
			if (ticket.isPresent()) {
				System.out.println(ticket.toString());
				Ticket ticketObj = ticket.get();

				Optional<Train> trainOptional = trainRepo.findById(ticketObj.getTrainId());
				if (trainOptional.isPresent()) {
					Train train = trainOptional.get();
					System.out.println("calculating your insurance amount: "
							+ train.getPrice() * ticketObj.getNumberOfTicket() * 0.005);
					InsuranceEntity entity = new InsuranceEntity(0L, ticketId,
							(train.getPrice() + train.getPrice() * 0.005) * ticketObj.getNumberOfTicket(),
							"INSURANCE-SUCCESS", train.getPrice() * ticketObj.getNumberOfTicket() * 0.005);
					InsuranceEntity updated =insuranceRepo.save(entity);
					Thread.sleep(2000);
					System.out.println("insurance after saving: "+updated);
					jmstemplate.convertAndSend(queue, updated.getInsuranceId());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
