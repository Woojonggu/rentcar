package User.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import User.User;
import User.UserDTO;
import Util.DBManager;

public class UserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private UserDAO() {}
	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	}
	//C
	public void createUser(UserDTO userDTO) {
		User user = new User(userDTO);
		
		this.conn = DBManager.getConnection();
		
		if(conn!=null) {
			String sql = "INSERT INTO users VALUES(?,?,?,?,?,?,DEFAULT);";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setInt(1, user.getUsersNum());
				this.pstmt.setString(2, user.getUsersName());
				this.pstmt.setString(3, user.getPhone());
				this.pstmt.setString(4, user.getClientID());
				this.pstmt.setString(5, user.getPassword());
				this.pstmt.setString(6, user.getAge());
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
				
			}
		}
	
		
	}
	public int getCustnoMax() {
		int usersnum = 1;
		
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT MAX(usersnum) FROM users";
			
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				this.rs.next();
				usersnum = this.rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {				
				DBManager.close(this.conn,this.pstmt,this.rs);
			}
		}
		
		
		return usersnum+1;
	}
	//R
	public User getUserInformation(String id, String password) {
		User user = null;
		
		this.conn= DBManager.getConnection();
		if(conn!=null) {
			String sql = "SELECT * FROM users WHERE clientID=? AND password = ?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setString(1, id);
				this.pstmt.setString(2, password);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int num = this.rs.getInt(1);
					String name = this.rs.getString(2);
					String phone = this.rs.getString(3);
					String clientId = this.rs.getString(4);
					String pw = this.rs.getString(5);
					String age = this.rs.getString(6);
					Timestamp time = this.rs.getTimestamp(7);
					
					user = new User(num,name,phone,clientId,pw,age,time);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
		}
		
		
		
		return user;
	}
	
	//U
	public void updateUser(UserDTO userDTO) {
		User user = new User(userDTO);
		
		this.conn = DBManager.getConnection();
		if(conn!=null) {
			String sql = "UPDATE users SET usersName=?,phone=?,clientID=?,password=?,age=? WHERE usersNum=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setString(1, user.getUsersName());
				this.pstmt.setString(2, user.getPhone());
				this.pstmt.setString(3, user.getClientID());
				this.pstmt.setString(4, user.getPassword());
				this.pstmt.setString(5, user.getAge());
				this.pstmt.setInt(6, user.getUsersNum());
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
	
	

}
