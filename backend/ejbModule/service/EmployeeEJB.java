package service;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB {


	@PersistenceContext
	private EntityManager em;
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    }
    
    public void addNew(EmployeeEntity employeeEntity)
    {
    	System.out.println("============================");
    	System.out.println(employeeEntity.getName());
    	em.persist(employeeEntity);
    	System.out.println("============================");
    }
    public List<EmployeeEntity> findEmployees() {
    	List<EmployeeEntity> employees = em.createQuery("Select e from  employee_tbl e"
    			,EmployeeEntity.class).getResultList();
    	return employees;
    }

}
