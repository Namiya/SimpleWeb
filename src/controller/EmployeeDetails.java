package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import data.EmployeeRepository;

@ManagedBean(name="details")
@SessionScoped
public class EmployeeDetails implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}

	private String id;
	private String name;
	private String email;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() throws Exception 
	{
		EmployeeRepository em = new EmployeeRepository();
		int index = em.searchEmployeeListByID(id).get(0);
		name = EmployeeRepository.emList.get(index).getName();
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}
	public String getEmail() throws Exception 
	{
		EmployeeRepository em = new EmployeeRepository();
		int index = em.searchEmployeeListByID(id).get(0);
		email = EmployeeRepository.emList.get(index).getEmail();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
