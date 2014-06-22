package controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name="annouce")
@SessionScoped
public class OrgAnnoucement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrgAnnoucement() {
		// TODO Auto-generated constructor stub
	}
	
	private String title;
	private String detailedMsg;
	private String footNotes;
	private String author;
	private String departmentSelected = "D1";
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetailedMsg() {
		return detailedMsg;
	}

	public void setDetailedMsg(String detailedMsg) {
		this.detailedMsg = detailedMsg;
	}

	public String getFootNotes() {
		return footNotes;
	}

	public void setFootNotes(String footNotes) {
		this.footNotes = footNotes;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public void onClickPubish() throws IOException
	{
		FacesContext.getCurrentInstance().getExternalContext().redirect("OrgAnnouncementView.xhtml");
	}
	
	public void onClickCancle()
	{
		title = "";
		detailedMsg = "";
		footNotes = "";
		author = "";
	}
	
	private static Map<String,Object> departments;
	static{
		departments = new LinkedHashMap<String,Object>();
		departments.put("Department1", "D1"); //lable, value
		departments.put("Department2", "D2");
		departments.put("Department3", "D3");
	}
 
	public Map<String,Object> getDepartments() {
		return departments;
	}

	public String getDepartmentSelected() {
		return departmentSelected;
	}

	public void setDepartmentSelected(String departmentSelected) {
		this.departmentSelected = departmentSelected;
	}

}
