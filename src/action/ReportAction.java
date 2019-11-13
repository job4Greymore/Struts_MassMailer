package action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import entity.Users;
import dao.UsersDao;

public class ReportAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ResultSet rs = null;
	Users bean = null;
	List<Users> beanList = null;
	UsersDao dbconnection = new UsersDao();
	private boolean noData = false;
	private String search;

	@Override
	public String execute() throws Exception {
		try {
			beanList = new ArrayList<Users>();
			rs = dbconnection.report(search);
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new Users();
					bean.setFirst_Name(rs.getString("First_Name"));
					bean.setLast_Name(rs.getString("Last_Name"));
					bean.setEmail(rs.getString("Email"));
					bean.setContact(rs.getString("Contact"));
					bean.setCompany(rs.getString("Company"));
					bean.setPosition(rs.getString("Position"));
					beanList.add(bean);
					System.out.println(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<Users> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<Users> beanList) {
		this.beanList = beanList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}

}
