package com.neoxamhr.webservice;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.EmployeeRepository;
import com.neoxamhr.dao.NotificationRepository;
import com.neoxamhr.dao.VacationRepository;
import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Notification;
import com.neoxamhr.entities.Vacation;
import com.neoxamhr.webservice.model.VacReceive;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class VacationController {
	
	@Autowired
	private VacationRepository vr;
	
	@Autowired
	private EmployeeRepository er;
	
	@Autowired
	private NotificationRepository nr;
	
	
	@RequestMapping(value="/allConge")
	public Iterable<Vacation> allVacation() {
		return vr.findAll();
	}
	
	@RequestMapping(value="/addEve")
	public List<String> addEve(@RequestBody VacReceive v ){		
		List<String> as= new ArrayList<String>();
		String firstname=v.getEmploye().split(" ")[0];
		String lastname=v.getEmploye().split(" ")[1];
		Employee e=er.findByFirstnameAndLastname(firstname, lastname).get(0);
		Vacation vacc=new Vacation(v.getTitle(),v.getStart(),v.getEnd(),e,v.getNbrDay());
		vacc.getStart().setHours(v.getTimestart().getHour());
		vacc.getStart().setMinutes(v.getTimestart().getMinute());
		vacc.getEnd().setHours(v.getTimeend().getHour());
		vacc.getEnd().setMinutes(v.getTimeend().getMinute());
		
		System.out.println( "eh " + v.getTimestart().getHour()+ "em "+ v.getTimestart().getMinute()+ "sh " + v.getTimeend().getHour()+ "sm " + v.getTimeend().getMinute() );
		
		List<Vacation> lv=vr.getAllVaccOfEmp(e.getIdEmpl());
		// eliminer le chefauchement de congé
		for( Vacation va : lv) {
			if(v.getStart().getTime() <= va.getEnd().getTime() && v.getEnd().getTime() >= va.getStart().getTime() ) {
				as.add(0, "cette date est déja reservé");
				return as;
			}
		}
		
		/*
		System.out.println((v.getEnd().getTime()-v.getStart().getTime())/3600000 + 1);
		int nbr=Integer.parseInt((v.getEnd().getTime()-v.getStart().getTime())/3600000 + 1+"");
		*/
		System.out.println(e.getSoldConge()-v.getNbrDay());
		if(e.getSoldConge()-v.getNbrDay()<0) {
			as.add(0, "votre solde de congé est insuffisant");
			return as;
		}
		e.setSoldConge(e.getSoldConge()-v.getNbrDay());
		vr.save(vacc);
		as.add(0, "congé demandé avec succés");
		
		// Ajout de notification
		try {
			Employee emp=er.findByFirstnameAndLastname(e.getResponsable().split(" ")[0], e.getResponsable().split(" ")[1]).get(0);
		Notification n=new Notification(e.getFirstname()+" "+ e.getLastname() + " demande un congé",emp,new Date());
		nr.save(n);
		}
		catch(Exception exp) {
			
		}
		
		return as;
	}
	
	@RequestMapping(value="/deleteEve")
	public @ResponseBody boolean deleteEve(@RequestBody int id ){		
		//returner le solde de congé supprimer
		Vacation v=vr.findById(id).get();
		int idEmp=v.getEmpl().getIdEmpl();
		Employee e=er.findById(idEmp).get();
		e.setSoldConge(e.getSoldConge()+v.getNbrDay());
		er.save(e);
		v.setEstcomf(-1);
		vr.save(v);
		Notification n=new Notification("Votre congé ("+v.getVacationName()+") a été réfusé",e,new Date());
		nr.save(n);
		//vr.deleteById(id);
		return true;
	}
	

	
	@RequestMapping(value="/empvac")
	public List<Employee> findEmpVac(){
		return vr.findEmpVac();
	}
	
	@RequestMapping(value="/newvacc")
	public List<Vacation> newVacc(){
		return vr.newVacc(new Date());
	}
	
	@RequestMapping(value="/comfirme")
	public boolean comfirme(@RequestParam int id) {
		Vacation v = vr.findById(id).get();
		v.setEstcomf(1);
		vr.save(v);
		Notification n=new Notification("votre congé ("+ v.getVacationName() +") a été accepté",v.getEmpl(),new Date());
		nr.save(n);
		return true;
	}
	
	@Scheduled(cron="0 45 16 ? * FRI")
	public void deleteEveNotCom() {
		vr.deleteVacNotCom();
		
	}
	
	@RequestMapping(value="/congeresp")
	public List<Vacation> congeOfResp(){
		return vr.congeOfResp();
	}
	
	@RequestMapping(value="/myvac")
	public List<Vacation> myVac(@RequestParam int id){
		return vr.myVac(id);
	}
	
	@RequestMapping(value="/myvacnotnotif")
	public List<Vacation> myVacNotNotif(@RequestParam int id){
		return vr.myVacNotNotif(id);
	}
	
	@RequestMapping(value="/annulnotif")
	public boolean anuulNotif(@RequestParam int id) {
		try {
			List<Vacation> v=vr.myVac(id);
			for(Vacation vac :v) {
				vac.setEstnotif(1);
			}
			vr.saveAll(v);
			return true;
		}
		catch(Exception ex) {
			return false;
		}
	}
	
	@RequestMapping(value="/congewait")
	public List<Vacation> congeWait(@RequestParam int id){
		return vr.myVacWait(id);
	}
	
	@RequestMapping(value="/findcongbyresp")
	public List<Vacation> findCongByResp(@RequestParam String name){
		return vr.findCongByResp(name);
	}
	
	@RequestMapping(value="/congnotvalid")
	public List<Vacation> congeNotValid(){
		return vr.findVacNotValid();
	}
	
	@Scheduled(cron="0 15 17 ? * *")
	public void VacNotValid() {
		List<Vacation> lv=vr.findVacNotValid();
		
		for(Vacation v : lv) {
			v.setEstcomf(-1);
		}
		
		vr.saveAll(lv);
		System.out.println("trtmnt fait");
	}
	
}
