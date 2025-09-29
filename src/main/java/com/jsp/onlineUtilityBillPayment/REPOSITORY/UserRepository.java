package com.jsp.onlineUtilityBillPayment.REPOSITORY;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.onlineUtilityBillPayment.DTO.User;

public interface UserRepository extends JpaRepository<User, Long>{//User class wrapper class primarykey6 corresponding datatype always give
	//now all the methods of JpaRepository we can use but only for User class by this object
	//for that we can 
	// specified ,we can also make our own query here if we want

}
