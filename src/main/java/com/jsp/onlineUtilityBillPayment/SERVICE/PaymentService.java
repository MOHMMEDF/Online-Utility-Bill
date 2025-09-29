package com.jsp.onlineUtilityBillPayment.SERVICE;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.onlineUtilityBillPayment.DTO.Bill;
import com.jsp.onlineUtilityBillPayment.DTO.Payment;
import com.jsp.onlineUtilityBillPayment.DTO.PaymentStatus;
import com.jsp.onlineUtilityBillPayment.REPOSITORY.BillRepository;
import com.jsp.onlineUtilityBillPayment.REPOSITORY.paymentRepository;

@Service
public class PaymentService {

	@Autowired
	private paymentRepository paymentRepo;
	@Autowired
	private BillRepository billRepo;
	
	//creating method
	
	public Payment payBill(Long billId) {
		Bill bill=billRepo.findById(billId).orElseThrow(()->new RuntimeException("BILL NOT FOUND"));
		if(bill.getPaymentstatus()==PaymentStatus.PAID) {
			throw new RuntimeException("BILL IS ALREADY PAID");
		}
		//if Bill is not paid then we will create Payment object
		//why we create Payment obj? Spring IOC already created,but Spring IOC created the same shared obj
		//for every entity, but suppose payment is not same again & again if 1 lightBill payment is we r paid,
		//and then again we have to paid another bill like water bill so that bill also not add to this will add new object for
		//Payment again we scan the QR again we Payment for a new thats why we r created the Payment object
		//manually
		
		Payment payment=new Payment();
		payment.setAmount(bill.getAmount());
		payment.setPaymentDate(LocalDate.now());
		payment.setStatus(PaymentStatus.PAID);
		payment.setBill(bill);
		
		//update bill
		bill.setPaymentstatus(PaymentStatus.PAID);
		bill.setPayment(payment);
		
		billRepo.save(bill);//saves both bill and payment via cascade
		//paymentRepo.save(payment);
		return payment;
	}
	//to get all payments for a particular user
	public List<Payment> getPaymentsByUser(Long userId){
		return paymentRepo.findByBillUserUserId(userId);
	}
	// to get a payment for a particular bill
	
	public Optional<Payment> getPaymentByBill(Long billId){
		return paymentRepo.findByBillBillId(billId);
	}
	
	// to get all payment objects
	public List<Payment> getAllPayment(){
		return paymentRepo.findAll();//inbuilt repository method
	}
}
