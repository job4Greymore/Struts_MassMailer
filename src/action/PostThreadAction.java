package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsersDao;

public class PostThreadAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String threadDetails,threadSubject;
//	private int userId;
	private String msg = "";
	UsersDao dbconnection = null;
	int ctr = 0;
	
	@Override
	public String execute(){
		dbconnection = new UsersDao();
		try {
			ctr = dbconnection.postThread(threadSubject, threadDetails ); //userId
			if (ctr > 0) {
				setMsg("Thread Published");
			} else {
				setMsg("Some error");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(threadSubject);
		System.out.println(threadDetails);
//		System.out.println(userId);
		return "SUCCESS";
	
	}

	public String getThreadSubject() {
		return threadSubject;
	}

	public void setThreadSubject(String threadSubject) {
		this.threadSubject = threadSubject;
	}

	public String getThreadDetails() {
		return threadDetails;
	}

	public void setThreadDetails(String threadDetails) {
		this.threadDetails = threadDetails;
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
