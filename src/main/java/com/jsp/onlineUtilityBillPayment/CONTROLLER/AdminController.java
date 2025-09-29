package com.jsp.onlineUtilityBillPayment.CONTROLLER;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.onlineUtilityBillPayment.DTO.Bill;
import com.jsp.onlineUtilityBillPayment.DTO.Payment;
import com.jsp.onlineUtilityBillPayment.DTO.User;
import com.jsp.onlineUtilityBillPayment.SERVICE.BillService;
import com.jsp.onlineUtilityBillPayment.SERVICE.PaymentService;
import com.jsp.onlineUtilityBillPayment.SERVICE.UserService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private BillService billService;
	
	@Autowired
	private PaymentService paymentService;
	
	@Autowired
	private UserService userService;
	
	//admin generate bill for each user
	
	@PostMapping("/generateBill")
	public ResponseEntity<Bill> generateBill(@RequestParam Long userid,@RequestBody Bill bill){
		return ResponseEntity.ok(billService.generateBill(bill, userid));
	}
	//admin views all user
	@GetMapping("/users")
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	//admin views all payments
	@GetMapping("/payments")
	public List<Payment> getAllPayments(){
		return paymentService.getAllPayment();
	}
	//admin view all bills
	@GetMapping("/bills")
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
}
