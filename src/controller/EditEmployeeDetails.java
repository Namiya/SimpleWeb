package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Employee;
import data.EmployeeRepository;

@ManagedBean(name="editDetails")
@SessionScoped
public class EditEmployeeDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public EditEmployeeDetails() {
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
	public String getName() throws Exception {
		EmployeeRepository em = new EmployeeRepository();
		int index = em.searchEmployeeListByID(id).get(0);
		name = EmployeeRepository.emList.get(index).getName();
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() throws Exception {
		EmployeeRepository em = new EmployeeRepository();
		int index = em.searchEmployeeListByID(id).get(0);
		email = EmployeeRepository.emList.get(index).getEmail();
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void onButtonDone() throws Exception
	{
		Employee employee = new Employee();
		EmployeeRepository em = new EmployeeRepository();
		
		employee.setId(id);
		employee.setName(name);
		employee.setEmail(email);
		
		em.updateEmployeeList(employee);
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("EmployeeDetails.xhtml");
	}
}
