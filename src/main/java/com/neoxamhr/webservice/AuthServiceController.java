package com.neoxamhr.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.entities.User;
import com.neoxamhr.services.UserRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthServiceController {
	
	@Autowired
	private UserRepository userRep;
	
	public User user=null;
	

	
	@PostMapping(value = "/login")
	public @ResponseBody User auth(@RequestBody AuthUser user) {
		System.out.println(user.toString());
		
		long i=userRep.countByLoginAndPassword(user.getLogin(), user.getPassword());
		this.user=userRep.findByLoginAndPassword(user.getLogin(), user.getPassword());
		
		System.out.println(i);

		return this.user;
	}
	
	/*
	@GetMapping("/add")
	public void addUser(@RequestParam String name,@RequestParam String lastname,@RequestParam String login,@RequestParam String password) {
		userRep.save(new User(name,lastname,login,password));
		System.out.println("user is added");
	}
	
	@GetMapping(value = "/login")
	public @ResponseBody User loginState() {
		return this.user;
	}
	
	 */
	
}
