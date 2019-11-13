package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsersDao;



public class LoginAction extends ActionSupport implements SessionAware{
	/** it keeps returning that illegal iwo
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String email,  password, firstName, lastName;
	private String msg = "";
	private Map<String, Object> sessionMap;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sessionMap = map;
	}
	
	@Override
	public String execute() {
		
		
		UsersDao dao =  new UsersDao(); // Instantiate the user dao object
		ResultSet rs = null;
		
		String result="ERROR";
		
		try {
			rs = dao.fetchUserDetails(email); //fetch the user detail by email
			if (rs.next()) {
				if (rs.getString("password").equals(password)){
					int userType = rs.getInt("userType"); 
					// 0 = superUser, 1 = Administrator, 2 = Standard Users
					
					//do a "switch case here"
					switch (userType) {
					case 0:
						result ="superUser";
						break;
					case 1:
						result ="administrator";
						break;

					default:
						result ="softwareProgrammer";
						break;
					}
					System.out.println(userType + result);
					// Put firstname, lastname and email in the session
					firstName=rs.getString("first_Name");
					lastName=rs.getString("last_Name");
					
					System.out.println(firstName + "Login action triggered");
					
					sessionMap.put("email", email);
					sessionMap.put("firstName", firstName);
					sessionMap.put("lastName", lastName);
					sessionMap.put("userType", userType);
//					result = "SUCCESS";
					//return SUCCESS;
				}else {
					msg = "Invalid Password";
					//return ERROR;
				}
				
			}else {
				msg ="Invalid Email";
				//return ERROR;
			}
			
		}catch(SQLException se) {
			msg = se.getMessage();
			//return ERROR;
			
		}catch(Exception e) {
			msg = e.getMessage();
			//return ERROR;
		}
		//msg = "Unknown Error";
		//return ERROR;
		System.out.println("end of login action");
		return result;
	}		

	
	public String logout() {
		sessionMap.clear();
//		sessionMap.remove("userId");
		System.out.println("logout Action Triggers");
		return "LOGOUT";
	}
	
}


