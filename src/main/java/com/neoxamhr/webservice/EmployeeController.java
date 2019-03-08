package com.neoxamhr.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Skills;
import com.neoxamhr.services.EmployeeRepository;
import com.neoxamhr.services.SkillsRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository er;
	
	@Autowired
	private SkillsRepository sr;
	
	@RequestMapping(value="/employe")
	public Iterable<Employee> getAllEmploye(){
		return er.findAll();
	}
	
	@PostMapping(value="/addEmp")
	public @ResponseBody void addEmploye(@RequestBody FormEmploye e ) {
		er.save(new Employee(e.getFirstname(),e.getLastname(),e.getEmail(),e.getAdress(),e.getPost(),e.getPhone()));
	}
	
	@PostMapping(value="/modif")
	public @ResponseBody boolean modifEmploye(@RequestBody FormEmploye e ) {
		Employee emp= er.findById(e.getId()).get();
		emp.setFirstname(e.getFirstname());
		emp.setLastname(e.getLastname());
		emp.setEmail(e.getEmail());			
		emp.setAdress(e.getAdress());
		if(e.getPhone()!=null)
		emp.setPhone(e.getPhone());
		er.save(emp);
		return true;
	}
	
	@RequestMapping(value = "/addimage")
	public void getImage(HttpServletResponse response) throws IOException {
		ClassPathResource imgFile = new ClassPathResource("image/sid.jpg");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}
	
	
	@RequestMapping(value="/addskil")
	public boolean addSkills(@RequestBody SkillsForm sf) throws InterruptedException {
		
		Employee e = er.findById(sf.getIdEmp()).get();
		
		Skills s= new Skills(sf.getNameSkil(),sf.getLevel(),e);
		//e.getSkillsEmpl().add(s);
		sr.save(s);
		//sr.save(s);
		
		return true;
	}
	
	/*
	@RequestMapping(value="/addskil")
	public boolean addSkills(@RequestBody SkillsForm sf) throws InterruptedException {
		Employee e = er.findById(sf.getIdEmp()).get();
		Skills s= new Skills(sf.getLevel());
		e.addSkills(s);
		sr.save(s);
		
		return true;
	}
	*/
	
}
