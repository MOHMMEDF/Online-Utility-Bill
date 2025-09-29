package com.jsp.onlineUtilityBillPayment.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.onlineUtilityBillPayment.DTO.Bill;
import com.jsp.onlineUtilityBillPayment.DTO.PaymentStatus;
import com.jsp.onlineUtilityBillPayment.DTO.User;
import com.jsp.onlineUtilityBillPayment.REPOSITORY.BillRepository;
import com.jsp.onlineUtilityBillPayment.REPOSITORY.UserRepository;

@Service
public class BillService {

	@Autowired
	private BillRepository billRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	
	// to generate Bill for user
	
		public Bill generateBill(Bill bill,Long userId) {
			User user=userRepo.findById(userId).orElseThrow(()->new RuntimeException("USER NOT FOUND!..."));
			
			bill.setUser(user);
			
			bill.setPaymentstatus(PaymentStatus.PENDING);//default we r setting
			
			//storing the bill into the database
			
			return billRepo.save(bill);
			
		}
		// to get Bill based on userId(for a particular user)
		public List<Bill> getBillsByUser(Long userId){
			return billRepo.findByUserUserId(userId);
		}
		
		//to get Bills based on status
		
		public List<Bill> getBillByStatus(PaymentStatus status){
			return billRepo.findByPaymentStatus(status);
		}
		
		// to get Bills based on userId and status
		
		public List<Bill> getBillsByUserAndStatus(Long userId,PaymentStatus status){
			return billRepo.findByUserUserIdAndPaymentStatus(userId, status);
		}
		
		// to get Bills based on billId
		public Optional<Bill> getBillById(Long billId){
			return billRepo.findById(billId);
		}
		
		//to get all bills
		public List<Bill> getAllBills() {
			return billRepo.findAll();
		}
		
}
