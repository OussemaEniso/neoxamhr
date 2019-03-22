package com.neoxamhr.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Vacation;
import com.neoxamhr.services.EmployeeRepository;
import com.neoxamhr.services.VacationRepository;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class VacationController {
	
	@Autowired
	private VacationRepository vr;
	
	@Autowired
	private EmployeeRepository er;
	
	@RequestMapping(value="/allConge")
	public Iterable<Vacation> allVacation() {
		return vr.findAll();
	}
	
	@RequestMapping(value="/addEve")
	public @ResponseBody boolean addEve(@RequestBody VacReceive v ){		
		String firstname=v.getEmploye().split(" ")[0];
		String lastname=v.getEmploye().split(" ")[1];
		Employee e=er.findByFirstnameAndLastname(firstname, lastname).get(0);
		vr.save(new Vacation(v.getTitle(),v.getStart(),v.getEnd(),e));
		return true;
	}
	@RequestMapping(value="/deleteEve")
	public @ResponseBody boolean addEve(@RequestBody int id ){		
		vr.deleteById(id);
		return true;
	}
	
	@RequestMapping(value="/empvac")
	public List<Employee> findEmpVac(){
		return vr.findEmpVac();
	}
	
}
