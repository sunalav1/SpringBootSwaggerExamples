package com.hello.swaggertest;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/UserTest/getUsers")
	public List<User> getUsers() {
		return Arrays.asList(
				new User("sam",1000L),
				new User("Rahul",2000L)
		);
	
	}
	
	@GetMapping("/api/UserTest/getUser/{userName}")
	public User getUser(@PathVariable("userName") final String userName) {
		return new User(userName,1000L);
	
	}
	
	public class User{
		private String userName;
		private Long sal;

		public User(String userName,Long sal) {
			this.userName=userName;
			this.sal=sal;
		}
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public Long getSal() {
			return sal;
		}
		public void setSal(Long sal) {
			this.sal = sal;
		}
		
	}
}
