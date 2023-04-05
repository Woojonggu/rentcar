package Car.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import Car.Car;
import Car.CarDTO;
import Util.DBManager;
import member.Member;

public class CarDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private CarDAO() {}
	private static CarDAO instance = new CarDAO();
	public static CarDAO getInstance() {
		return instance;
	}
	//C
	public void createUser(CarDTO CarDTO) {
		Car car = new Car(CarDTO);
		
		this.conn = DBManager.getConnection();
		
		if(conn!=null) {
			String sql = "INSERT INTO car VALUES(?,?,?,?,?,?,DEFAULT);";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setInt(1, car.getCarNum());
				this.pstmt.setString(2, car.getCarName());
				this.pstmt.setString(3, car.getHourPrice());
				this.pstmt.setString(4, car.getYear());
				this.pstmt.setString(5, car.getSeater());
				this.pstmt.setString(6, car.getPossibleAge());
				
			
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
				
			}
		}
	
		
	}
	//R
	public ArrayList<Car> getCarList() {
		ArrayList<Car> list = new ArrayList<Car>();
		
		this.conn= DBManager.getConnection();
		if(conn!=null) {
			String sql = "SELECT * FROM car";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					int num = this.rs.getInt(1);
					String name = this.rs.getString(2);
					String price = this.rs.getString(3);
					String year = this.rs.getString(4);
					String seat = this.rs.getString(5);
					String age = this.rs.getString(6);
					Timestamp time = this.rs.getTimestamp(7);
					
					Car car = new Car(num,name,price,year,seat,age,time);
					list.add(car);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
			
			
		}
		
		
		return list;
	}
	
	//U
	public void updateUser(CarDTO CarDTO) {
		Car user = new Car(CarDTO);
		
		this.conn = DBManager.getConnection();
		if(conn!=null) {
			String sql = "UPDATE car SET carName=?,hourPrice=?,year=?,seater=?,possibleAge=? WHERE carNum=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.pstmt.setString(1, user.getCarName());
				this.pstmt.setString(2, user.getHourPrice());
				this.pstmt.setString(3, user.getYear());
				this.pstmt.setString(4, user.getSeater());
				this.pstmt.setString(5, user.getPossibleAge());
				this.pstmt.setInt(6, user.getCarNum());
			
				
				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}
	}
	
}
