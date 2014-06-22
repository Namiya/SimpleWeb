package data;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.SessionScoped;

import model.Employee;

@SessionScoped
public class EmployeeRepository {

	public EmployeeRepository() {
		// TODO Auto-generated constructor stub
		setInitialList();
	}
	
	public static List<Employee> emList = new ArrayList<Employee>();
	private List<Integer> searchList = new ArrayList<Integer>();
	
	private void setInitialList()
	{
		if( emList.isEmpty())
		{
			Employee employee = new Employee();
			employee.setName("name1");
			employee.setId("1");
			employee.setEmail("name1@test.com");
			emList.add(employee);
			
			employee = new Employee();
			employee.setName("name1");
			employee.setId("2");
			employee.setEmail("name1_1@test.com");
			emList.add(employee);
			
			employee = new Employee();
			employee.setName("name2");
			employee.setId("3");
			employee.setEmail("name2@test.com");
			emList.add(employee);
		}
	}
	
	public List<Employee> getEmployeeList()
	{
		return emList;
	}
	
	public void updateEmployeeList(Employee employee) throws Exception 
	{
		try
		{
			for(int i=0; i<emList.size(); i++)
			{
				Employee old = emList.get(i);
				if(old.getId().equals(employee.getId()))
				{
					old.setName(employee.getName());
					old.setEmail(employee.getEmail());
				}
			}
		}
		finally
		{
		}
	
	}
	
	@SuppressWarnings("finally")
	public List<Integer> searchEmployeeListByName(String name) throws Exception
	{
		searchList.clear();
		
		try
		{
			for(int i=0; i<emList.size(); i++)
			{
				if(emList.get(i).getName().equals(name))
					searchList.add(i);
			}
		}
		finally
		{
			return searchList;
		}
	}
	
	@SuppressWarnings("finally")
	public List<Integer> searchEmployeeListByID(String id) throws Exception
	{
		searchList.clear();
		
		try
		{
			for(int i=0; i<emList.size(); i++)
			{
				if(emList.get(i).getId().equals(id))
					searchList.add(i);
			}
		}
		finally
		{
			return searchList;
		}
	}
}
