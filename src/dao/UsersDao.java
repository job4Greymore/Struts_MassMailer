package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

 public class UsersDao {

	public static Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return
					
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/M5-Project", "root", "123abc4d");
			} catch (Exception e) {
			e.printStackTrace();
			return null;
			}
	}
	// method for save user data in database  --- FOR REGISTRATION 
	public int registerUser(String first_Name, String last_Name, String email, String
	contact, String password) throws Exception {
	int i = 0;
	try {
	String sql = "INSERT INTO USERS(first_Name, last_Name, email, contact, password) VALUES (?,?,?,?,?)";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	ps.setString(1, first_Name);
	ps.setString(2, last_Name);
	ps.setString(3, email);
	ps.setString(4, contact);
	ps.setString(5, password);
	i = ps.executeUpdate();
	return i;
	} catch (Exception e) {
	e.printStackTrace();
	return i;
	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	
	// method for save user data in database  --- FOR REGISTRATION 
	public int registerAdmin(String email, String contact, String password) throws Exception {
	int i = 0;
	try {
	String sql = "INSERT INTO USERS(first_Name, last_Name, email, contact, password, userType) VALUES (?,?,?,?,?,?)";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	ps.setString(1, "");
	ps.setString(2, "");
	ps.setString(3, email);
	ps.setString(4, contact);
	ps.setString(5, password);
	ps.setInt(6, 1);
	i = ps.executeUpdate();
	return i;
	} catch (Exception e) {
	e.printStackTrace();
	return i;
	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	
	
	// method for fetch saved user data -- FOR SEARCH RESULTS
	public ResultSet report(String search) throws SQLException, Exception {
	ResultSet rs = null;
	try {
	String sql = 
			"SELECT * FROM USERS where email LIKE '%" + search +"%' or first_Name Like '%" 
	+ search +"%' or last_Name Like '%" + search +"%';";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	rs = ps.executeQuery();
	return rs;
	} catch (Exception e) {
	e.printStackTrace();
	return null;
	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	// method for fetch saved user data -- FOR Restricted SEARCH RESULTS
	public ResultSet reportAll() throws SQLException, Exception {
	ResultSet rs = null;
	try {
	String sql = "SELECT * FROM USERS";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	rs = ps.executeQuery();
	return rs;
	} catch (Exception e) {
	e.printStackTrace();
	return null;
	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	
	// method for fetch old data to be update -- THIS IS FOR EDIT PROFILE
	public ResultSet fetchUserDetails(String email) throws SQLException,
	Exception {
	ResultSet rs = null;
	try {
	String sql = "SELECT * FROM USERS WHERE EMAIL=?";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	ps.setString(1, email);
	rs = ps.executeQuery();
	return rs;
	} catch (Exception e) {
	e.printStackTrace();
	return null;
	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	
	// method for update new data in database
	public int updateUserDetails(String first_Name, String last_Name, String email,
	String contact, String company, String position)
	throws SQLException, Exception {
		ResultSet rs = null;
	getConnection().setAutoCommit(false);
	int i = 0;
	try {
	String sql = "UPDATE USERS SET FIRST_NAME=?,LAST_NAME=?, CONTACT=?, COMPANY=?, POSITION=? WHERE EMAIL=?";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	System.out.println("this is in your UserDao - updatetUserDetails");
	ps.setString(1, first_Name);
	System.out.println("first Name in Userdao - Update get");
	ps.setString(2, last_Name);
	System.out.println("last Name in Userdao - Update get");
	ps.setString(3, contact);
	System.out.println("contact in Userdao - Update get");
	ps.setString(4, company);
	System.out.println("company in Userdao - Update get");
	ps.setString(5, position);
	System.out.println("position in Userdao - Update get");
	ps.setString(6, email);
	System.out.println("email in Userdao - Update get");
	i = ps.executeUpdate();
	System.out.println(i);
	return i;
	
	} catch (Exception e) {
	e.printStackTrace();
	System.out.println("catching exception E in UserDao");
	
	getConnection().rollback();
	return i;

	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	
	// method for delete the record
	public int deleteUserDetails(String email) throws SQLException,
	Exception {
	getConnection().setAutoCommit(false);
	int i = 0;
	try {
	String sql = "DELETE FROM USERS WHERE EMAIL=?";
	PreparedStatement ps =
	getConnection().prepareStatement(sql);
	ps.setString(1, email);
	i = ps.executeUpdate();
	return i;
	} catch (Exception e) {
	e.printStackTrace();
	getConnection().rollback();
	return 0;
	} finally {
	if (getConnection() != null) {
	getConnection().close();
	}
	}
	}
	
	
	public int loginUser(String email, String password) {
		// TODO Auto-generated method stub
		
	
		return 0;
	}
//	
//	public int logoutUser() {
//		
//	}
	
	public int postThread(String threadSubject, String threadDetails) throws Exception{
		int i = 0;
		try {
		String sql = "INSERT INTO THREADS(threadSubject, threadDetails) VALUES (?,?)";
		PreparedStatement ps =
		getConnection().prepareStatement(sql);
		ps.setString(1, threadSubject );
		ps.setString(2, threadDetails );
//		ps.setInt(3, thread_userId);
		i = ps.executeUpdate();
		return i;
		} catch (Exception e) {
		e.printStackTrace();
		return i;
		} finally {
		if (getConnection() != null) {
		getConnection().close();
		}
		}
		
	}
	public ResultSet viewThreads() throws SQLException, Exception {
		ResultSet rs = null;
		try {
		String sql = "SELECT * FROM THREADS";
		PreparedStatement ps =
		getConnection().prepareStatement(sql);
		rs = ps.executeQuery();
		return rs;
		} catch (Exception e) {
		e.printStackTrace();
		return null;
		} finally {
		if (getConnection() != null) {
		getConnection().close();
		}
		}
		}
	}