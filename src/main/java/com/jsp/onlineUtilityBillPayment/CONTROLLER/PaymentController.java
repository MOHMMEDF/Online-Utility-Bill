package com.jsp.onlineUtilityBillPayment.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlineUtilityBillPayment.DTO.Payment;
import com.jsp.onlineUtilityBillPayment.SERVICE.PaymentService;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentservice;
	
	@PostMapping("/pay")
	public ResponseEntity<Payment> payBill(@RequestParam Long billId){
		return ResponseEntity.ok(paymentservice.payBill(billId));
	}
	
	
	@GetMapping("/byuser")
	public List<Payment> getPaymentByUser(@RequestParam Long userId){
		return paymentservice.getPaymentsByUser(userId);
	}
	
	@GetMapping("/bybill")
	public ResponseEntity<Payment> getPaymentByBill(@RequestParam Long billId){
		return paymentservice.getPaymentByBill(billId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@GetMapping("/all")
	public List<Payment> getAllPayment(){
		return paymentservice.getAllPayment();
	}
	
}
