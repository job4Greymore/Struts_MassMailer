package action;

import java.sql.ResultSet;
import java.util.*;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.Threads;
import dao.UsersDao;

public class ViewThreadsAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	public List<Threads> getBeanList() {
		return beanList;
	}


	Threads bean = null;
	List<Threads> beanList = null;
	UsersDao dbconnection = new UsersDao();
	private boolean noData = false;

	
	public String execute() throws Exception {
		HttpSession session = ServletActionContext.getRequest().getSession();
		String threadSubject = (String) session.getAttribute("threadSubject");
		System.out.println("View threadsubject = " + threadSubject);
		
		String result = "ERROR";
		String msg = "Unknown Error";
		try {
			beanList = new ArrayList<Threads>();
			rs = dbconnection.viewThreads();
			int i = 0;
			if(rs != null) {
			while(rs.next()) {
				i++;
				bean = new Threads();
				bean.setThreadSubject(rs.getString("threadSubject"));
//				bean.setThreadDetails(rs.getString("threadDetails"));
				beanList.add(bean);
				System.out.println(bean);
			}
		}
		if(i==0) {
			noData = false;
		}else {
			noData = true;
		}
	} catch (Exception e) {
		e.printStackTrace();
	}	
		System.out.println(bean);
		return "SUCCESS";
	}
	
	



	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

	public void setBeanList(List<Threads> beanList) {
		this.beanList = beanList;
	}




	
	public boolean isNoData() {
		return noData;
	}
	
	
	
	
	
	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	
	
	
	
	
//	public String getSearch() {
//		return search;
//	}
//	
//	
//	
//	
//	
//	public void setSearch(String search) {
//		this.search = search;
//	}
}

