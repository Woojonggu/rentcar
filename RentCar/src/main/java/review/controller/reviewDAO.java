package review.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import Util.DBManager;
import review.review;
import review.reviewDTO;

public class reviewDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private reviewDAO() {
	}

	private static reviewDAO instance = new reviewDAO();

	public static reviewDAO getInstance() {
		return instance;
	}

	// C

	public void CreateReview(reviewDTO reviewDto) {
		review review = new review(reviewDto);

		this.conn = DBManager.getConnection();

		if (conn != null) {
			String sql = "INSERT INTO review VALUES(?,?,?,?,DEFAULT)";

			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setInt(1, review.getReviewNum());
				this.pstmt.setString(2, review.getTittle());
				this.pstmt.setString(3, review.getContents());
				this.pstmt.setString(4, review.getWriterId());
			

				this.pstmt.execute();
			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}
		}

	}
	public int getReviewNoMax() {
		int num = 1;
		
		
		this.conn = DBManager.getConnection();
		if(this.conn != null) {
			String sql = "SELECT MAX(reviewNum) FROM review";
			
			
			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = this.pstmt.executeQuery();
				
				this.rs.next();
				num = this.rs.getInt(1);
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {				
				DBManager.close(this.conn,this.pstmt,this.rs);
			}
		}
		
		
		return num+1;
	}

	// R
	public ArrayList<review> getReviewList() {
		ArrayList<review> list = new ArrayList<review>();

		this.conn = DBManager.getConnection();

		if (conn != null) {
			String sql = "SELECT * FROM review";

			try {
				this.pstmt = this.conn.prepareStatement(sql);
				this.rs = pstmt.executeQuery();
				while (this.rs.next()) {
					int reviewNum = this.rs.getInt(1);
					String tittle = this.rs.getString(2);
					String contents = this.rs.getString(3);
					String writerId = this.rs.getString(4);
					Timestamp time = this.rs.getTimestamp(5);
				

					review review = new review(reviewNum, tittle, contents, writerId, time);
					list.add(review);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}
		}

		return list;
	}
	

	// R
	public review getReview(int reviewNum1) {
		review review = null;

		this.conn = DBManager.getConnection();

		if (conn != null) {
			String sql = "SELECT * FROM review WHERE reviewNum=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setInt(1, reviewNum1);
				this.rs = this.pstmt.executeQuery();

				while (this.rs.next()) {
					int reviewNum = this.rs.getInt(1);
					String tittle = this.rs.getString(2);
					String contents = this.rs.getString(3);
					String writerId = this.rs.getString(4);
					Timestamp time = this.rs.getTimestamp(5);

					review = new review(reviewNum, tittle, contents, writerId, time);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt, rs);
			}

		}

		return review;
	}

	// U
	public void updateReview(reviewDTO reviewDto) {
		review review = new review(reviewDto);

		this.conn = DBManager.getConnection();

		if (conn != null) {
			String sql = "UPDATE review SET tittle=?,contents=? WHERE reviewNum=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setString(1, review.getTittle());
				this.pstmt.setString(2, review.getContents());
				this.pstmt.setInt(3, review.getReviewNum());

				this.pstmt.execute();

			}

			catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}

		}

	}
	public void deleteReview(reviewDTO reviewDto) {
		
		review review = new review(reviewDto);

		this.conn = DBManager.getConnection();

		if (conn != null) {
			String sql = "DELETE FROM review WHERE reviewNum=?";

			try {
				this.pstmt = this.conn.prepareStatement(sql);

				this.pstmt.setInt(1, review.getReviewNum());

				this.pstmt.execute();
			}

			catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBManager.close(conn, pstmt);
			}

		}
		
	}

}
