package com.neoxamhr.webservice;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
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
import com.neoxamhr.dao.EmployeeRepository;
import com.neoxamhr.dao.NotificationRepository;
import com.neoxamhr.dao.SkillsRepository;
import com.neoxamhr.dao.TeamRepository;
import com.neoxamhr.dao.UserRepository;
import com.neoxamhr.dao.VacWithOutPayRepository;
import com.neoxamhr.dao.VacationRepository;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Notification;
import com.neoxamhr.entities.Skills;
import com.neoxamhr.entities.Team;
import com.neoxamhr.entities.User;
import com.neoxamhr.entities.VacWithOutPay;
import com.neoxamhr.entities.Vacation;
import com.neoxamhr.webservice.model.FormEmploye;
import com.neoxamhr.webservice.model.FormPost;
import com.neoxamhr.webservice.model.SkillsForm;
import com.neoxamhr.webservice.model.VacReceive;


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
	
	@Autowired
	private VacWithOutPayRepository vw;
	
	@Autowired
	private NotificationRepository nr;
	
	
	
	@RequestMapping(value="/employe")
	public Iterable<Employee> getAllEmploye(){
		return er.findAll();
	}
	
	@PostMapping(value="/addEmp")
	public @ResponseBody void addEmploye(@RequestBody FormEmploye e ) {
		System.out.print(e.getFirstname()+e.getLastname()+e.getEmail()+e.getAdress()+ e.getPost()+e.getPh()+e.getResponsable());
		Employee emp = new Employee(e.getFirstname(),e.getLastname(),e.getEmail(),e.getAdress(),e.getPost(),e.getPh(),e.getResponsable(),e.getEstResp(),e.getSexe(),e.getCin(),e.getCnss(),e.getNaiss(),e.getVille(),e.getDateent(),e.getMat(),e.getSalaire());
		User user=new User(e.getEmail(),"");
		ur.save(user);
		emp.setUser(user);
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
		er.save(emp);
		System.out.print(emp.toString());
	}
	
	@RequestMapping(value="/delete")
	public boolean delete(@RequestParam int id) {
		System.out.println(id);
		Employee e= er.findById(id).get();
		User u=e.getUser();
		ur.delete(u);
		vr.deleteVac(id);
		er.delete(e);
		
		return true;
	}
	
	@PostMapping(value="/modifempl")
	public @ResponseBody boolean modifEmploye(@RequestBody FormEmploye e ) {
		Employee emp= er.findById(e.getId()).get();
		emp.setFirstname(e.getFirstname());
		emp.setLastname(e.getLastname());
		//emp.setEmail(e.getEmail());			
		emp.setAdress(e.getAdress());
		if(e.getPh() != 0)
		emp.setPhone(e.getPh());
		emp.setBirthDay(e.getNaiss());
		emp.setCin(e.getCin());
		emp.setCnss(e.getCnss());
		emp.setVille(e.getVille());
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
		e.setEstResp(post.getEstresp());
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
		List<Employee> le=er.findByResp(e.getFirstname()+" "+e.getLastname() );
		
		return le;
	}
	
	// tous les responsables
	@RequestMapping(value="allresp")
	public List<Employee> allResp(){
		return er.allResponsable();
	}
	/*
	@Scheduled(cron="0 0 18 L * ?")
	public void addScore() {
		List<Employee> le= (List<Employee>) er.findAll();
		for(Employee e : le ) {
			e.setSoldConge(e.getSoldConge()+1.75);
		}
		System.out.println("+1.75 monthly");
		er.saveAll(le);
	}
	
	*/
	@Scheduled(cron="0 40 9 ? * MON-FRI")
	public void addScore() {
		List<Employee> le= (List<Employee>) er.findAll();
		for(Employee e : le ) {
			e.setSoldConge(e.getSoldConge()+1.75);
		}
		System.out.println(new Date());
		er.saveAll(le);
		
	}
	
	
	@RequestMapping(value="/nbrconge")
	public int nbrConge(@RequestParam int id) {
		try {
			return vr.nbrConge(id);
		}
		catch(Exception e) {
			return 0;
		}
	}
	
	@RequestMapping(value="/empofresp")
	public List<Employee> emplOfResp(@RequestParam String firstname,@RequestParam String lastname){
		return er.EmplOfResp(firstname + " " + lastname);
	}
	
	@RequestMapping(value="/addcongenopay")
	public List<String> addCongeNoPay(@RequestBody VacReceive e) {
		List<String> ls=new ArrayList<String>();
		try {
			System.out.println(e.getIdVac()+e.getTitle()+e.getStart());
			
			Employee emp=er.findById(e.getIdVac()).get();
			VacWithOutPay vwop=vw.findByTypeIgnorCase(e.getTitle().split(" ")[0]).get(0);
			
			Set<VacWithOutPay> lv = vw.autorizeVac(e.getIdVac());
			boolean x=lv.add(vwop);
			System.out.println(x);
			
			List<Vacation> lvac=vr.getAllVaccOfEmp(emp.getIdEmpl());
			// eliminer le chefauchement de congé
			for( Vacation va : lvac) {
				if(e.getStart().getTime() <= va.getEnd().getTime() && e.getEnd().getTime() >= va.getStart().getTime() ) {
					ls.add("date deja reservé");
					return ls;
				}
			}
			
			if(x==true) {
				emp.setVacNoPay(lv);
				er.save(emp);
				Vacation v= new Vacation(e.getTitle(), e.getStart(), e.getEnd(), emp, 0);
				vr.save(v);
				ls.add("demande ajouté");
				Notification n =new Notification(v.getEmpl().getFirstname()+ " " +v.getEmpl().getLastname() +"a demandé un congé",v.getEmpl(),new Date());
				nr.save(n);
				return ls;
			}
			else {
				ls.add("Congé deja consommé");
				return ls;
			}
			
			
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
			ls.add("505");
			return ls;
		}
		
	}
	
	@RequestMapping(value="/deletecong")
	public boolean deleteCong(@RequestBody int id) {
		try {
			Vacation v=vr.findById(id).get();
			int idEmp=v.getEmpl().getIdEmpl();
			Employee e=er.findById(idEmp).get();
			
			e.setSoldConge(e.getSoldConge()+v.getNbrDay());
			er.save(e);
			vr.deleteById(id);
			try {
			Set<VacWithOutPay> sv= vw.autorizeVac(idEmp);
				//Set<VacWithOutPay> sv= new HashSet<VacWithOutPay>();
			VacWithOutPay vwo=vw.findByTypeIgnorCase(v.getVacationName().split(" ")[0]).get(0);
			sv.remove(vwo);
			e.setVacNoPay(sv);
			er.save(e);
			Notification n=new Notification("votre congé ("+v.getVacationName()+") a été réfusé",e,new Date());
			nr.save(n);
			
			}
			catch(Exception ex) {
				System.out.println("error");
			}
			
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
}
