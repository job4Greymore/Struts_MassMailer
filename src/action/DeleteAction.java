package action;

import dao.UsersDao;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = -146601914103585418L;
	String email, msg;
	UsersDao dao = new UsersDao();

	@Override
	public String execute() throws Exception {
		try {
			int isDeleted = dao.deleteUserDetails(email);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	public String getemail() {
		return email;
	}

	public void setUemail(String email) {
		this.email = email;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}