package com.neoxamhr.webservice;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.dao.VacWithOutPayRepository;
import com.neoxamhr.dao.VacationRepository;
import com.neoxamhr.entities.VacWithOutPay;
import com.neoxamhr.entities.Vacation;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class VacWithOutPayController {
	
	@Autowired
	private VacWithOutPayRepository vr;
	
	@RequestMapping(value="/newvacnopay")
	public boolean addVacNoPay(@RequestParam String name, @RequestParam String dur) {
		vr.save(new VacWithOutPay(name,dur));
		return true;
	}
	
	@RequestMapping(value="/allvacnopay")
	public List<VacWithOutPay> allVacNoPay(){
		return (List<VacWithOutPay>) vr.findAll();
	}
	
	@RequestMapping(value="/editvacwithout")
	public boolean editVacWithoutSolde(@RequestParam int id,@RequestParam String dura, @RequestParam String type) {
		try {
			VacWithOutPay vw=vr.findById(id).get();
			vw.setType(type);
			vw.setPeriode(dura);
			vr.save(vw);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	@RequestMapping(value="/myvacnopay")
	public Set<VacWithOutPay> autorizeVac(@RequestParam int id){
		return vr.autorizeVac(id);
	}
	
	
	

}
