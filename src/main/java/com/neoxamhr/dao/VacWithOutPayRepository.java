package com.neoxamhr.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.neoxamhr.entities.VacWithOutPay;

public interface VacWithOutPayRepository extends CrudRepository<VacWithOutPay, Integer> {

	@Query("select v from VacWithOutPay v where v.type=?1")
	List<VacWithOutPay> findByTypeIgnorCase(String type);
	
	@Query("select v from VacWithOutPay v join v.emp vemp on vemp.idEmpl= ?1 ")
	Set<VacWithOutPay> autorizeVac(int id);
	
	//SELECT * FROM `vac_with_out_pay` WHERE NOT EXISTS (SELECT * FROM employee_vac_no_pay WHERE employee_vac_no_pay.vac_no_pay_id=vac_with_out_pay.id and employee_vac_no_pay.emp_id_empl=39)
	
	
}
