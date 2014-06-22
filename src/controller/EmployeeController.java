package controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Employee;
import data.EmployeeRepository;



@ManagedBean(name="controller")
@SessionScoped
public class EmployeeController implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private List<Employee> employeeFound = new ArrayList<Employee>();
	
	@PostConstruct 
	public void init()
	{
		employeeFound.clear();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEmListEmpty() {
		return employeeFound.isEmpty();
	}

	public List<Employee> getEmployeeFound() {
		return employeeFound;
	}

	public void setEmployeeFound(List<Employee> employeeFound) {
		this.employeeFound = employeeFound;
	}

	public void Search() throws Exception
	{
		employeeFound.clear();
		try {
			EmployeeRepository em = new EmployeeRepository(); 
			List<Employee> allEmployeeList = EmployeeRepository.emList;
			List<Integer> searchList = null;
			if (!id.isEmpty())  
			{
				searchList = em.searchEmployeeListByID(id);
				if (!name.isEmpty()) 
					if (!allEmployeeList.get(searchList.get(0)).getName().equals(name))	
						searchList.clear();
			}
			else
			if(!name.isEmpty()) 
					searchList = em.searchEmployeeListByName(name);
				
			for (int i=0; i<searchList.size(); i++)
				employeeFound.add(allEmployeeList.get(searchList.get(i)));
        } 
		catch (Exception e) 
        {
			 FacesContext.getCurrentInstance().addMessage("search failed", new FacesMessage(e.getMessage()));
        }	
	}

}
