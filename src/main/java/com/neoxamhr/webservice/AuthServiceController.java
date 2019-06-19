package com.neoxamhr.webservice;


import java.util.UUID;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.EmployeeRepository;
import com.neoxamhr.dao.UserRepository;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.User;
import com.neoxamhr.webservice.model.AuthUser;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthServiceController {
	
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private EmployeeRepository er;
	
	public User user=null;
	

	
	@PostMapping(value = "/login")
	public @ResponseBody Employee auth(@RequestBody AuthUser user) {
		Employee e=null;
		
		long i=userRep.countByMailAndPassword(user.getLogin(), user.getPassword());
		System.out.println(i);
		try {
			this.user=userRep.findByMailAndPassword(user.getLogin(), user.getPassword());
			e = er.findProfil(this.user.getMail());
		}
		catch (Exception exp) {
			
		}

		return e;
	}
	
	@GetMapping(value="/pwdmod")
	public boolean pswdmodif(@RequestParam String pwd,@RequestParam String id) {
		System.out.println(pwd +" "+id);
		User u=userRep.findByMail(id);
		u.setPassword(pwd);
		userRep.save(u);
		return true;
	}
	
	
	
	/*
	@GetMapping("/add")
	public void addUser(@RequestParam String name,@RequestParam String lastname,@RequestParam String login,@RequestParam String password) {
		userRep.save(new User(name,lastname,login,password));
		System.out.println("user is added");
	}
	
	 */
	
}
