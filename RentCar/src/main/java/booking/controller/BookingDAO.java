package booking.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
