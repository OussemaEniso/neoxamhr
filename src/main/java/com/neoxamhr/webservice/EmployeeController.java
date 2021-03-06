package com.neoxamhr.webservice;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Skills;
import com.neoxamhr.entities.Team;
import com.neoxamhr.entities.User;
import com.neoxamhr.services.EmployeeRepository;
import com.neoxamhr.services.SkillsRepository;
import com.neoxamhr.services.TeamRepository;
import com.neoxamhr.services.UserRepository;
import com.neoxamhr.services.VacationRepository;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository er;
	
	@Autowired
	private SkillsRepository sr;
	
	@Autowired
	private VacationRepository vr;
	
	@Autowired
	private TeamRepository tr;
	
	@Autowired
	private UserRepository ur;
	
	@RequestMapping(value="/employe")
	public Iterable<Employee> getAllEmploye(){
		return er.findAll();
	}
	
	@PostMapping(value="/addEmp")
	public @ResponseBody void addEmploye(@RequestBody FormEmploye e ) {
		System.out.print(e.getFirstname()+e.getLastname()+e.getEmail()+e.getAdress()+ e.getPost()+e.getPh()+e.getResponsable());
		
		Employee emp = new Employee(e.getFirstname(),e.getLastname(),e.getEmail(),e.getAdress(),e.getPost(),e.getPh(),e.getResponsable());
		System.out.print(e.getEstResp());
		emp.setEstResp(e.getEstResp());
		Team t=null;
		try {
			t=tr.findByTeamNameIgnoreCase(e.getDep()).get(0);
			emp.setTeam(t);
		}
		catch(Exception ex) {
			t=new Team(e.getDep());
			tr.save(t);
			emp.setTeam(t);
		}
		// crée un compte pour chaque employee nouveauté créé
		User u=new User(emp.getEmail()," ");
		ur.save(u);
		er.save(emp);
		System.out.print(emp.toString());
		
	}
	
	@RequestMapping(value="/delete")
	public boolean delete(@RequestParam int id) {
		System.out.println(id);
		Employee e= er.findById(id).get();
		User u=ur.findById(id-1).get();
		ur.delete(u);
		vr.deleteVac(id);
		er.delete(e);
		
		return true;
	}
	
	@PostMapping(value="/modifempl")
	public @ResponseBody boolean modifEmploye(@RequestBody FormEmploye e ) {
		
		
		
		User u= ur.findById(e.getId()-1).get();
		u.setMail(e.getEmail());
		System.out.println(u.toString());
		ur.save(u);
		
		Employee emp= er.findById(e.getId()).get();
		emp.setFirstname(e.getFirstname());
		emp.setLastname(e.getLastname());
		emp.setEmail(e.getEmail());			
		emp.setAdress(e.getAdress());
		if(e.getPh() != 0)
		emp.setPhone(e.getPh());
		System.out.println(emp.toString());
		er.save(emp);
		 
		return true;
	}
	
	/*
	@RequestMapping(value = "/addimage")
	public void getImage(HttpServletResponse response) throws IOException {
		ClassPathResource imgFile = new ClassPathResource("image/sid.jpg");
		response.setContentType(MediaType.IMAGE_JPEG_VALUE);
		StreamUtils.copy(imgFile.getInputStream(), response.getOutputStream());
	}
	*/
	
	@RequestMapping(value="/addskil")
	public boolean addSkills(@RequestBody SkillsForm sf) throws InterruptedException {
		
		Employee e = er.findById(sf.getIdEmp()).get();
		
		Skills s=null;
		
		try {
			s= sr.findSkills(sf.getIdEmp(),sf.getNameSkil()).get(0);
			s.setLevel(sf.getLevel());
			System.out.println("deja existe");
		}
		catch(Exception exp) {
			s= new Skills(sf.getNameSkil(),sf.getLevel(),e);
			
		}
		sr.save(s);
		
		return true;
	}
	
	@RequestMapping(value="/notyet")
	public List<Employee> notYet(){
		return er.findNotYet();
	}
	
	@RequestMapping(value="/modifpost")
	public boolean modifPost(@RequestBody FormPost post) {
		Employee e=er.findById(post.getId()).get();
		e.setPost(post.getPost());
		e.setResponsable(post.getResp());
		List<Employee> le=new ArrayList<Employee>();
		le.add(e);
		
		Team t=null;
		try {
			t=tr.findByTeamNameIgnoreCase(post.getDep()).get(0);
			e.setTeam(t);
		}
		catch(Exception ex) {
			t=new Team(post.getDep(),le);
			tr.save(t);
			e.setTeam(t);
		}
		
		er.save(e);
		
		return true;
	}
	
	@RequestMapping(value="findprofil")
	public Employee findProfil(@RequestParam String mail) {
		return er.findProfil(mail);
		
	}
	
	@RequestMapping(value="listacomf")
	public List<Employee> listCom(@RequestParam String id){
		Employee e=er.findById(Integer.parseInt(id)).get();
		List<Employee> le=er.findByResp(e.getFirstname());
		return le;
	}
	
	
}
