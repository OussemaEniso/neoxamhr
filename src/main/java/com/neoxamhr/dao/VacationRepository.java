package com.neoxamhr.dao;

import java.util.Date;
import java.util.List;



import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.neoxamhr.entities.Employee;
import com.neoxamhr.entities.Vacation;

public interface VacationRepository extends CrudRepository<Vacation, Integer> {
	
	@Query("select e from Employee e join Vacation v on v.empl.idEmpl = e.idEmpl")
	List<Employee> findEmpVac();
	
	@Query("select v from Vacation v where v.empl.idEmpl = ?1 ")
	List<Vacation> getAllVaccOfEmp(int id);
	
	@Modifying
	@Transactional
	@Query("delete from Vacation v where v.empl.idEmpl= ?1")
	void deleteVac(int id); 
	
	@Query("select v from Vacation v where v.start > ?1")
	List<Vacation> newVacc(Date d);
	
	@Query("select sum( datediff(v.end,v.start)+1) from Vacation v where v.empl.idEmpl=?1 and v.estcomf <> -1 group by v.empl.idEmpl")
	int nbrConge(int id);
	
	@Modifying
	@Transactional
	@Query("delete from Vacation v where v.estcomf= -1")
	void deleteVacNotCom();
	
	//les congés des responsables
	@Query("select distinct v from Vacation v join Employee e on e.estResp=1 and v.estcomf=0")
	List<Vacation> congeOfResp();
	
	@Query("select v from Vacation v where v.empl.idEmpl=?1 and v.estcomf=0")
	public List<Vacation> myVacWait(int id);
	
	@Query("select v from Vacation v where v.empl.idEmpl=?1")
	public List<Vacation> myVac(int id);
	
	@Query("select v from Vacation v where v.empl.idEmpl=?1 and v.estnotif=0")
	public List<Vacation> myVacNotNotif(int id);
	
	@Query("select v from Vacation v join Employee e on e.responsable=?1 and v.empl.idEmpl=e.idEmpl and v.estcomf=0 ")
	List<Vacation> findCongByResp(String name);
	
	@Query("select v from Vacation v where datediff(v.start,now()) < 0 and v.estcomf = 0 ")
	List<Vacation> findVacNotValid();

}
