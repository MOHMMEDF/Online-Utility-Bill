package com.jsp.onlineUtilityBillPayment.REPOSITORY;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlineUtilityBillPayment.DTO.Payment;

public interface paymentRepository extends JpaRepository<Payment, Long>{

	//this method returns all payments where the bill is associated with a user
	//whose userId is matches the given userId
	
	List<Payment> findByBillUserUserId(Long userId);
	
	//this method returns the payment that is associated with a Bill having the given billId-
	//wrapped Payment inside optional
	
	Optional<Payment> findByBillBillId(Long billId);
	
	//optional Class is used to avoid NULLExCEPTION ,because instead of optional we can also
	//store in Payment obj but if in obj is Payment is not present then Null is present automatically
	//but at the end of project if we not give proper validation then will give the NULLEXCEPTION
	//so in optional class if Payment is not present then it is empty inside not a NULL as default
	//other wise at the end will get a NULLEXCEPTION
}
