package com.cts;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class EmployeeDAO {
	public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("EmpDB");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
         
        Employee newEmp = new Employee();
       newEmp.setName("puja");
       newEmp.setEmail("puja@gmail.com");
         newEmp.setAddress("hyd");
        entityManager.persist(newEmp);
        
        Employee employee = entityManager.find(Employee.class, 1);
        System.out.println(employee);
        CriteriaQuery<Employee> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Employee.class);
        Root<Employee> root = criteriaQuery.from(Employee.class);
        
        List<Employee> li= entityManager.createQuery(criteriaQuery).getResultList();
        for(Employee s:li){
        	System.out.println("Id :"+s.getId()+"  name="+s.getName()+" email="+s.getEmail()+"  address"+s.getAddress());
        }
        entityManager.getTransaction().commit();
         
        entityManager.close();
        factory.close();
    }

}
