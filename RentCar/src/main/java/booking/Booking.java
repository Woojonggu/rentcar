package booking;

import java.sql.Timestamp;

public class Booking {
	private int clientNum;
	private String carNum,carName,borrowDate,totalPayment, returnDate;
	Timestamp registDate ;
	
	
	public Booking(int clientNum, String carNum, String carName, String borrowDate, String totalPayment, String returnDate, Timestamp registDate) {
		this.clientNum = clientNum;
		this.carNum = carNum;
		this.carName = carName;
		this.borrowDate = borrowDate;
		this.totalPayment = totalPayment;
		this.returnDate = returnDate;
		this.registDate = registDate;
	}
	public Booking(BookingDTO bookingDto) {
		this.clientNum = bookingDto.getClientNum();
		this.carNum = bookingDto.getCarNum();
		this.carName = bookingDto.getCarName();
		this.borrowDate = bookingDto.getBorrowDate();
		this.totalPayment = bookingDto.getTotalPayment();
		this.returnDate = bookingDto.getReturnDate();
		this.registDate = bookingDto.getRegistDate();
	}
	

	public int getClientNum() {
		return clientNum;
	}


	public String getCarNum() {
		return carNum;
	}


	public String getCarName() {
		return carName;
	}


	public String getBorrowDate() {
		return borrowDate;
	}


	public String getTotalPayment() {
		return totalPayment;
	}


	public String getReturnDate() {
		return returnDate;
	}


	public Timestamp getRegistDate() {
		return registDate;
	}

}
