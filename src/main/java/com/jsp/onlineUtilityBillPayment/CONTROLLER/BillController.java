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
import com.jsp.onlineUtilityBillPayment.DTO.PaymentStatus;
import com.jsp.onlineUtilityBillPayment.SERVICE.BillService;

@RestController
@RequestMapping("/api/bills")
public class BillController {

	@Autowired
	private BillService billservice;
	
	@PostMapping("generate")
	public ResponseEntity<Bill> generateBIll(@RequestBody Bill bill,@RequestParam Long userId){
		return ResponseEntity.ok(billservice.generateBill(bill, userId));
	}
	
	@GetMapping("/byuser")
	public List<Bill> getBillsByUser(@RequestParam Long userId){
		return billservice.getBillsByUser(userId);
	}
	
	@GetMapping("/bystatus")
	public List<Bill> getBillsByStatus(@RequestParam PaymentStatus status){
		return billservice.getBillByStatus(status);
	}
	
	@GetMapping("/byid")
	public ResponseEntity<Bill> getBillById(@RequestParam Long billid){
		return billservice.getBillById(billid)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/byuserstatus")
	public List<Bill> getBillByUserIdAndStatus(@RequestParam Long userId,@RequestParam  PaymentStatus status){
		return billservice.getBillsByUserAndStatus(userId, status);
	}
}
