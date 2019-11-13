package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class dashboardAction extends ActionSupport implements SessionAware {
	private Map<String, Object> sessionMap;
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0 ;
		
	}
	
	public String execute() {
	String result = "";
	int userType = (int) sessionMap.get("userType"); 
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
	
	return result;
	}
	
	

}
