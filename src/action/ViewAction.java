package action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsersDao;
import entity.Users;

public class ViewAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	Users bean = null;
	public Users getBean() {
		return bean;
	}

	public void setBean(Users bean) {
		this.bean = bean;
	}

	List<Users> beanList = null;
	UsersDao dao = new UsersDao();
	private boolean noData = false;
	
	public String execute() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String email = (String) session.getAttribute("email");
		System.out.println("View Action = " + email);
		
		String result = "ERROR";
		String msg = "Unknown Error";
		try {
			ResultSet rs = dao.fetchUserDetails(email);
			if (rs.next()) {
	
				
					bean = new Users();
					bean.setFirst_Name(rs.getString("First_Name"));
					bean.setLast_Name(rs.getString("Last_Name"));
					bean.setEmail(rs.getString("Email"));
					bean.setContact(rs.getString("Contact"));
					bean.setCompany(rs.getString("Company"));
					bean.setPosition(rs.getString("Position"));
					
					System.out.println(" editProfile Button clicked at home. = " + bean.getFirst_Name());
					result = "SUCCESS";
	
			} 
		}catch(SQLException se) {
			
			msg = se.getMessage();
			
		}catch(Exception e) {
			msg = e.getMessage();
			//return ERROR;
		}
		//msg = "Unknown Error";
		//return ERROR;
		return result;
	}		
		
		
		
	

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
