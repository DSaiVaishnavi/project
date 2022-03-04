package com.microservice.user.service;

import com.microservice.user.exception.WrongFormatException;

import com.microservice.user.helper.userDtoToUser;
import com.microservice.user.userDTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;

import java.util.Objects;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private userDtoToUser UserDtoToUser;

	@Autowired
	private RestTemplate restTemplate;


	public User registerVoter(User user) throws WrongFormatException {
		user.setStatus(false);
		return userRepository.save(user);
	}


	public User updateVoter(UserDTO userDTO) throws Exception {
		User user = UserDtoToUser.convertUserDtoToUser(userDTO);
		User userReturn = userRepository.findByVoterId(user.getVoterId());
		if(userReturn.getVoterId()==0 && userReturn==null){
			throw new Exception();
		}
		else{
			userReturn.setName(user.getName());
			userReturn.setDOB(user.getDOB());
			return userRepository.save(userReturn);
		}

	}






	public User fetchVoterByAadhaarAndPassword(String aadhaar, String voterPassword) throws  com.voterservice.voter.exceptions.IncorrectCredentialsException {
		User user=userRepository.findByAadhaarCardNo(aadhaar);
		if(user.getPassword().equals(voterPassword)){
			return user;
		}
		else{
			throw  new com.voterservice.voter.exceptions.IncorrectCredentialsException("Incorrect Credentials");
		}
	}


	public User getinfo(String aadharcardno) {
		return userRepository.findByAadhaarCardNo(aadharcardno);
	}


	public User updatePassword(String aadharcardno, String password) throws WrongFormatException {

		User userDB=userRepository.findByAadhaarCardNo(aadharcardno);

		if((userDB.getAadhaarCardNo().equals(aadharcardno)))
		if(Objects.nonNull(password)&&!"".equals(userDB.getPassword()))
			if(!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$"))
			throw new WrongFormatException("wrong password format");
			else
				userDB.setPassword(password);

		return userRepository.save(userDB);
	}

	public User fetchUserByAadharcardNo(String tempAadhar) {
		return  userRepository.findByAadhaarCardNo(tempAadhar);

	}
}
