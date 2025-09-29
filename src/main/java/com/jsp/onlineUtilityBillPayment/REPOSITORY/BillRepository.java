package com.jsp.onlineUtilityBillPayment.REPOSITORY;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlineUtilityBillPayment.DTO.Bill;
import com.jsp.onlineUtilityBillPayment.DTO.PaymentStatus;

public interface BillRepository extends JpaRepository<Bill, Long> {

	//find all bill records where the user.userid fields equal to the provided userid
	List<Bill> findByUserUserId(Long userId);
	
	//find all rows from Bill table where the status column equals to the given status
	
	List<Bill> findByPaymentStatus(PaymentStatus status);
	
	//find all the Bill entries where the associated user's userId equals the given value,
	//AND the status equals the given status
	
	List<Bill> findByUserUserIdAndPaymentStatus(Long userId,PaymentStatus status);

	
	
	
	
}
