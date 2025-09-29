package com.jsp.onlineUtilityBillPayment.SERVICE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.onlineUtilityBillPayment.DTO.Role;
import com.jsp.onlineUtilityBillPayment.DTO.User;
import com.jsp.onlineUtilityBillPayment.REPOSITORY.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
	//to register user
	public User registeruser(User user) {
		//if user role is null,then we set it to default role i.e,USER
		if(user.getRole()==null) {
			user.setRole(Role.USER);
		}
		//if user's role is !=null,we save the object into the database 
		return userRepo.save(user);//we r saving the user obj and returning
		//because why waste memory no use so directly return if no use further
	}
	
	//to get user by based on id
	
	public Optional<User> getUserById(Long id){
		return userRepo.findById(id);
	}
	
	// to get all the user's
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	
}
