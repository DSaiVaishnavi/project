package com.microservice.user;

import com.microservice.user.entity.User;
import com.microservice.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserServiceApplicationTests {
	@Autowired
	UserRepository userRepository;


	@Test
	@Order(1)
	@Rollback(value=false)
	void candidateLoads(){
		assertNotNull(userRepository.findAll());
	}


	@Test
	@Order(2)
	@Rollback(value=false)
	public void saveUserTest(){
		User user= User.builder()
				.voterId(1L)
				.aadhaarCardNo("962433408758")
				.Password("Anjali$123")
				.status(false)
				.name("Abc")
				.build();
		userRepository.save(user);
		Assertions.assertThat(user.getVoterId()).isGreaterThan(0);


	}

	@Test
	@Order(3)
	@Rollback(value=false)
	public void getUserTest(){
		User user=userRepository.findByAadhaarCardNo("962433408758");
		//Assertions.assertThat(Objects.equals(user.getVoterId(), 34));
		Assertions.assertThat(user.getAadhaarCardNo().equals("962433408758"));

	}

	@Test
	@Order(4)
	@Rollback(value=false)
	public void getListUsersTest(){
		List<User> users=userRepository.findAll();
		Assertions.assertThat(users.size()).isGreaterThan(0);
	}

	@Test
	@Order(5)
	@Rollback(value=false)
	public void editUser(){
		User user=userRepository.findByAadhaarCardNo("962433408758");
		user.setName("Shabbir");
//			user.setDOB(2022-02-22);
		User user3=userRepository.save(user);
		Assertions.assertThat(user3.getName()).isEqualTo("Shabbir");
	}



	@Test
	@Order(6)
	@Rollback(value=false)
	public void changeUserPasswordTest(){
		User user=userRepository.findByAadhaarCardNo("962433408758");
		user.setPassword("Abcefgh@123");
		User userPT=userRepository.save(user);
		Assertions.assertThat(userPT.getPassword()).isEqualTo("Abcefgh@123");
	}



//
}
