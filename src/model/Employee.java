package model;



public class Employee {

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, String id, String email)
	{
		this.name = name;
		this.id = id;
		this.email = email;
	}
	
	private String name;   
	private String id;
	private String email;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   

}
