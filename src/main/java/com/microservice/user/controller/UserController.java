package com.microservice.user.controller;

import com.microservice.user.entity.UserLogin;
import com.microservice.user.exception.WrongFormatException;
import com.microservice.user.exception.AadharcardAlreadyExistException;
import com.microservice.user.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.microservice.user.entity.User;
import com.microservice.user.service.UserService;

@RestController
@RequestMapping("/voter")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/VoterRegistration")
	public User registerVoter(@RequestBody User user) throws WrongFormatException, AadharcardAlreadyExistException {
		System.out.println("inside registervoter method");
		String tempAadhar =user.getAadhaarCardNo();
			if (tempAadhar != null && !"".equals(tempAadhar)) {
				User userObj = userService.fetchUserByAadharcardNo(tempAadhar);
				if (userObj != null) {
					throw new AadharcardAlreadyExistException("User with " + tempAadhar + "  already Exists");
				}
			}

			if(tempAadhar.isEmpty() || tempAadhar.isBlank() || !tempAadhar.matches("^[0-9]{12}$") ) {
				throw new WrongFormatException("Adharcardno is in Wrong Format");
			}

			String tempPassword=user.getPassword().toString();
			if(!tempPassword.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
				throw new WrongFormatException("Password is in wrong format");

			return userService.registerVoter(user);

		}


	@PostMapping("/voterLogin")
	public String loginVoter(@RequestBody UserLogin user) throws com.voterservice.voter.exceptions.IncorrectCredentialsException, AadharcardAlreadyExistException {

		String aadhar = user.aadhaarCardNo;
		String voterPassword= user.password;

		User userObj = null;
		if ( aadhar != null && voterPassword != null) {
			userObj = userService.fetchVoterByAadhaarAndPassword(aadhar, voterPassword);
		}
		if (userObj == null) {
			throw new com.voterservice.voter.exceptions.IncorrectCredentialsException("Incorrect Credentials");
		}
		return "login SuccessFull";
	}



	@PutMapping("/updateVoter")
	public User updateVoter(@RequestBody UserDTO userDto) throws Exception {
		System.out.println("inside update voter method");
		return  userService.updateVoter(userDto);
	}

	@PutMapping("/updatePassword")
	public User updatePassword(String aadharcardno,String password) throws WrongFormatException {
		System.out.println("inside update password method");
		return  userService.updatePassword(aadharcardno,password);
	}

	@GetMapping("/userinfo/{aadharcardno}")
	public User getinfo(@PathVariable("aadharcardno") String aadharcardno){
		System.out.println("inside getinfo method");

		return userService.getinfo(aadharcardno);
	}


}
