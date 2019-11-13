package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import dao.UsersDao;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateAction extends ActionSupport implements SessionAware{
	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName = "", lastName = "", email = "", contact= "", company="", position="";
	private String msg = "";
	private Map<String, Object> sessionMap ;
	ResultSet rs = null;
	UsersDao dao = new UsersDao();
	
	
	String submitType;

	@Override
	public String execute() throws SQLException, Exception {
		System.out.println("updateAction executing ");
		System.out.println(submitType +" entered the execution method");
//		ServletActionContext.getRequest().getSession();
//		System.out.println("Update Action = " + firstName); 
		try {
			if (submitType.equals("updatedata")) {
				rs = dao.fetchUserDetails(email.trim());
				if (rs != null) {
					while (rs.next()) {
						firstName = rs.getString("FIRSTNAME");
						System.out.println("fname getto ");
						lastName = rs.getString("LASTNAME");
						System.out.println("=lname getto ");
						email = rs.getString("EMAIL");
						System.out.println("=email getto ");
						contact = rs.getString("CONTACT");
						System.out.println("=contact getto ");
						company = rs.getString("COMPANY");
						System.out.println("=company getto ");
						position = rs.getString("POSITION");
						System.out.println("=position getto ");
						
					}
				}
			} else {
				int i = dao.updateUserDetails(firstName, lastName, email, contact, company, position);
				if (i > 0) {
					msg = "Record Updated Successfuly";
					return "SUCCESS";
				} else {
					msg = "error";
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
			return "ERROR";
		
		} catch (Exception e) {
			e.printStackTrace();
			return "ERROR";
		}
		
		
		System.out.println("updateAction- returning result now");
		return "SUCCESS";
	}
// Upon removing this get submitType it creates a Nullpoint exception.
	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public Map<String, Object> getSessionMap() {
		return sessionMap;
	}
	public void setSessionMap(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		setSessionMap(map);
	}


}
