package com.restfulServices.restfulServicePart1.employe;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class EmployeeDaoService {
    private static List<Employee> emp =  new ArrayList<Employee>();
    private static int empCount = 3;
    static {
        emp.add(new Employee(1, "name", 22));
        emp.add(new Employee(2, "rahul", 25));
        emp.add(new Employee(3, "harry", 23));
    }
    public List<Employee> findAll(){
        return emp;
    }
    public Employee saveEmployee(Employee emp1){
        if(emp1.getId() == null){
            emp1.setId(++empCount);
        }
        emp.add(emp1);
        return emp1;
    }
    public Employee findOne(int id){
        for(Employee em:emp){
            if(em.getId() == id){
                return em;
            }
        }
        return null;
    }
    public Employee delete(int id){
        Iterator<Employee> iterator = emp.iterator();
        while (iterator.hasNext()){
            Employee em = iterator.next();
            if(em.getId() == id){
                iterator.remove();
                return em;
            }
        }
        return null;
    }
    public Employee updateEmployeeDetails(Employee employee){
        for(Employee ep1:emp){
            if(ep1.getId() == employee.getId()){
                ep1.setName(employee.getName());
                ep1.setAge(employee.getAge());
                return ep1;
            }
        }
        return null;
    }
}
