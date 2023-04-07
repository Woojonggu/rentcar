package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Util.DBManager;
import booking.Booking;
import booking.BookingDTO;

public class BookingDAO {
	

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private BookingDAO() {}
	private static BookingDAO instance = new BookingDAO();
	public static BookingDAO getInstance() {
		
		return instance;
	}
	
	//C
	
	public void createUser(BookingDTO bookingDto) {
		Booking booking = new Booking(bookingDto);
		
		this.conn = DBManager.getConnection();
		
		if(conn!=null) {
			String sql = "INSERT INTO booking VALUES(?,?,?,?,?,?,DEFAULT);";
			
			try {
				
				
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setString(1, booking.getCarNum());
				this.pstmt.setString(2, booking.getCarName());
				this.pstmt.setString(3, booking.getBorrowDate());
				this.pstmt.setString(4, booking.getTotalPayment());
				this.pstmt.setInt(5, booking.getClientNum());
				this.pstmt.setString(6, booking.getReturnDate());

				this.pstmt.execute();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
				
			}
		}
			
	}
	//R
	public ArrayList<Booking> getBookingList(int usernum) {
		ArrayList<Booking> list = new ArrayList<Booking>();
		
		this.conn=DBManager.getConnection();
		if(conn!=null) {
			String sql = "SELECT * FROM booking WHERE clientnum=?";
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				
				this.pstmt.setInt(1, usernum);
				this.rs = this.pstmt.executeQuery();
				
				while(this.rs.next()) {
					String carNum = this.rs.getString(1);
					String carName = this.rs.getString(2);
					String borrowDate = this.rs.getString(3);
					String totalPrice = this.rs.getString(4);
					int clientNum = this.rs.getInt(5);
					String returnDate = this.rs.getString(6);
					Timestamp time = this.rs.getTimestamp(7);
					
					Booking booking = new Booking(clientNum, carNum, carName, borrowDate, totalPrice, returnDate, time);
					list.add(booking);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		
			
		}
		
		return list;
	}
}
