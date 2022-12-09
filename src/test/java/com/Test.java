package com;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.dao.EmployeeDao;
import com.dto.Employee;

/**
 * @author Admin
 *
 */
public class Test {
	public static void main(String[] args) {  
		
//		Resource resource  = new ClassPathResource("config/applicationContext.xml");
//		BeanFactory factory = new XmlBeanFactory(resource);
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
		EmployeeDao e = (EmployeeDao) context.getBean("edao");
		
		List<Employee> res =  e.getEmployee("0622080085");
		System.out.println(res.size()) ;
		for(Employee emp : res) {
			System.out.println(emp.getId());
			System.out.println(emp.getName());
		}
		
		
	}
}
